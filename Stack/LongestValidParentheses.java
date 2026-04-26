import java.util.*;

// Problem: Longest Valid Parentheses
// Difficulty: Hard
//  Company: Microsoft Google

// Approach: Stack (store indices)
//
// Steps:
// 1. Push -1 initially (base)
// 2. Traverse string:
//    - If '(' → push index
//    - If ')':
//         pop
//         if stack empty → push current index
//         else → calculate length = i - stack.peek()
// 3. Track max length

// Time Complexity: O(n)
// Space Complexity: O(n)

public class LongestValidParentheses {

    public static int longestValid(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValid(s)); // Output: 4
    }
}
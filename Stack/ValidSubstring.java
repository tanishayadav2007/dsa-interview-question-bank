// Problem: Longest Valid Parentheses Substring
// Difficulty: Medium
// Company: Amazon

// Approach:
// Use stack to store indices
// Push -1 initially to handle edge cases

// Steps:
// 1. Push -1 into stack
// 2. Traverse string:
//    - If '(' → push index
//    - If ')':
//         pop
//         if stack empty → push current index
//         else → calculate length = i - stack.peek()
// 3. Keep track of max length


import java.util.*;

public class ValidSubstring {

    public static int lengthSubstring(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
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
        String s = "()(())(";
        System.out.println(lengthSubstring(s)); // Output: 6
    }
}
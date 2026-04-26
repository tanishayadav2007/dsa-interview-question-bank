import java.util.*;

// Problem: IPL 2021 - Final (Longest Valid Parentheses)
// Difficulty: Hard
// Company: Amazon

// Problem Statement:
// Given a string S consisting only of '(' and ')',
// find the length of the longest valid (well-formed) parentheses substring.
//
// A substring is valid if:
// - Every opening parenthesis has a closing parenthesis
// - Closing parenthesis comes after opening parenthesis
//
// Note:
// The smallest valid substring "()" has length = 2

// Approach:
// We use a stack to store indices instead of characters.
//
// Idea:
// - Stack helps track unmatched positions
// - We use indices to calculate length of valid substring
//
// Steps:
// 1. Push -1 into stack (base index)
// 2. Traverse the string:
//    - If '(' → push its index
//    - If ')':
//         pop from stack
//         if stack becomes empty → push current index (reset base)
//         else → calculate length = i - stack.peek()
// 3. Keep track of maximum length

// Time Complexity:
// O(n)

// Space Complexity:
// O(n)

// Example:
// Input:
// S = "()(())("
//
// Output:
// 6
//
// Explanation:
// Longest valid substring is "()(())"

public class IPLFinal {

    public static int longestValid(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // base index

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);  // reset base
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "()(())(";
        System.out.println(longestValid(s)); // Output: 6
    }
}

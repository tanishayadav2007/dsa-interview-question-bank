// Problem: Count the Reversals
// Company: Amazon (Common Interview Question)

// Problem Statement:
// Given a string s consisting of only opening and closing curly brackets '{' and '}',
// find the minimum number of reversals required to make the string balanced.
// A reversal means changing '{' to '}' or vice-versa.
//
// If it is not possible to balance the string, return -1.

// Examples:
// Input: s = "}{{}}{{{"
// Output: 3
// Explanation:
// One possible balanced string is "{{{}}{}}"
// Minimum reversals required = 3
//
// Input: s = "{{}{{{}{{}}{{"
// Output: -1
// Explanation:
// String length is odd, so it cannot be balanced.

// Approach:
// We use a stack to remove already balanced pairs
// and then count the remaining unbalanced brackets.
//
// Steps:
// 1. Check if length of string is odd:
//    - If yes → return -1 (not possible)
//
// 2. Traverse the string:
//    - If '{' → push into stack
//    - If '}':
//         - If stack not empty and top is '{' → pop (balanced pair)
//         - Else → push '}' into stack
//
// 3. After traversal:
//    - Stack contains only unbalanced brackets
//
// 4. Count:
//    - Let m = size of stack
//    - Count number of '{' → open
//
// 5. Formula:
//    - Reversals = (m / 2) + (open % 2)

// Time Complexity:
// O(n) → traverse string once

// Space Complexity:
// O(n) → stack usage

import java.util.*;

public class CountReversal {

    public static int countRev(String s) {
        int n = s.length();

        // If length is odd → not possible
        if (n % 2 != 0) return -1;

        Stack<Character> stack = new Stack<>();

        // Remove balanced pairs
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        // Count remaining brackets
        int m = stack.size();
        int open = 0;

        while (!stack.isEmpty()) {
            if (stack.pop() == '{') open++;
        }

        // Apply formula
        return (m / 2) + (open % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        int result = countRev(s);

        System.out.println("Minimum reversals required: " + result);

        sc.close();
    }
}
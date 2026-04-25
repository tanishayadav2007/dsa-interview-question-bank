// Problem: Reverse Each Word in a Given String
// Difficulty: Medium
//Company:Paytm Zoho Flipkart Amazon Microsoft Payu MAQ Software Adobe

// Problem Statement:
// You are given a string s. You need to reverse each word in it where the words are separated by spaces
// and return the modified string.
//
// Note:
// The string may contain:
// - Leading spaces
// - Trailing spaces
// - Multiple spaces between words
//
// The returned string should:
// - Have each word reversed
// - Contain only a single space between words
// - Not contain any extra spaces

// Approach:
// We use a Stack to reverse each word.
//
// A stack follows LIFO (Last In First Out), which helps in reversing characters.
//
// Steps:
// 1. Traverse the string character by character.
// 2. If the character is not a space → push it into the stack.
// 3. If the character is a space:
//    - If stack is not empty → pop all elements and append to result (reverses word)
//    - Add a single space to result
// 4. After traversal, pop remaining characters from stack (last word).
// 5. Trim the result to remove extra spaces at the end.

// Time Complexity:
// O(n)

// Space Complexity:
// O(n)

// Example:
// Input:
// " i like this program very much "
//
// Output:
// "i ekil siht margorp yrev hcum"


import java.util.*;

public class ReverseEachWord {

    public static String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If not space, push to stack
            if (ch != ' ') {
                stack.push(ch);
            } 
            else {
                // If space encountered, pop all characters (reverse word)
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        result.append(stack.pop());
                    }
                    result.append(" "); // add single space
                }
            }
        }

        // Handle last word (if any)
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // Remove extra space at end
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String input = " i like this program very much ";
        String output = reverseWords(input);

        System.out.println("Input  : " + input);
        System.out.println("Output : " + output);
    }
}
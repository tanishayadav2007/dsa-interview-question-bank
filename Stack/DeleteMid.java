// Problem: Delete Middle Element of Stack
// Company: Amazon / Flipkart (Common Interview Question)

// Problem Statement:
// Given a stack s, delete the middle element of the stack without using any additional data structure.
// Middle element is defined as: floor((size_of_stack + 1) / 2) using 1-based indexing from the bottom.

// Approach:
// Since we cannot use recursion or extra data structures (as per constraint),
// we simulate removal using another stack.
// Steps:
// 1. Find size of stack.
// 2. Calculate middle index.
// 3. Pop elements from original stack.
// 4. Skip the middle element.
// 5. Push remaining elements into another stack.
// 6. Restore elements back to original stack.

// Time Complexity: O(n)
// Space Complexity: O(n)

// Example:
// Input: s = [10, 20, 30, 40, 50]
// Output: [50, 40, 20, 10]

import java.util.*;

public class DeleteMid {

    public static void deleteMid(Stack<Integer> s1) {
        if (s1.isEmpty()) return;

        Stack<Integer> s2 = new Stack<>();

        int size = s1.size();
        int mid = size / 2;

        // Move elements to s2 and skip middle
        for (int i = 0; i < size; i++) {
            int val = s1.pop();

            if (i == mid) {
                continue; // skip middle element
            }

            s2.push(val);
        }

        // Restore elements back to original stack
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(50);
        stack.push(40);
        stack.push(30);
        stack.push(20);
        stack.push(10);

        System.out.println("Original Stack: " + stack);

        deleteMid(stack);

        System.out.println("After Deleting Middle: " + stack);
    }
}
// Difficulty: Hard
// Company: Amazon, Microsoft, Google

// Problem Statement:
// Given an array arr[], find the maximum of minimum values for every window size k (1 ≤ k ≤ n).
// For each window size, compute all minimums and return the maximum among them.

// Approach: Monotonic Stack
//
// Idea:
// For each element, find the length of the window where it is the minimum.
// Use Previous Smaller Element (PSE) and Next Smaller Element (NSE).
// Then map each element to its valid window length.
// Finally, fill the result array and propagate maximums backward.

// Time Complexity: O(n)
// Space Complexity: O(n)

// Example:
// Input:  [10, 20, 30, 50, 10, 70, 30]
// Output: [70, 30, 20, 10, 10, 10, 10]

import java.util.*;

public class MaxOfMinWindow {

    public static int[] maxOfMin(int[] arr) {

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            res[len - 1] = Math.max(res[len - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};
        System.out.println(Arrays.toString(maxOfMin(arr)));
    }
}
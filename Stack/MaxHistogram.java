// Difficulty: Hard
// Company: Flipkart, Amazon, Microsoft, Google, Goldman Sachs

// Problem Statement:
// Given an array arr[] representing heights of histogram bars,
// where each bar has width = 1, find the largest rectangular area
// that can be formed using contiguous bars.

// Approach: Monotonic Stack (Optimal)
//
// Idea:
// For each bar, find how far it can extend left and right
// such that it remains the smallest height in that range.
// Use stack to maintain increasing heights and calculate area
// when a smaller element appears.

// Time Complexity: O(n)
// Space Complexity: O(n)

// Example:
// Input:  [60, 20, 50, 40, 10, 50, 60]
// Output: 100

import java.util.*;

public class MaxHistogram {

    public static int largestRectangleArea(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {

            int height = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && height < arr[stack.peek()]) {

                int h = arr[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, h * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(largestRectangleArea(arr));
    }
}

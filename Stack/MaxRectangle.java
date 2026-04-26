// Difficulty: Hard
// Company: Flipkart, Amazon, Microsoft, Samsung, MakeMyTrip, Google

// Problem Statement:
// Given a 2D binary matrix mat[][] containing only 0s and 1s,
// find the maximum area of a rectangle formed using only 1's.

// Approach:
// Treat each row as a histogram and apply Largest Rectangle in Histogram.
// Build heights row by row and compute max area.

// Time Complexity: O(n * m)
// Space Complexity: O(m)

// Example:
// Input:
// [[0,1,1,0],
//  [1,1,1,1],
//  [1,1,1,1],
//  [1,1,0,0]]
// Output: 8

import java.util.*;

public class MaxRectangle {

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

    public static int maxRectangle(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[] height = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };

        System.out.println(maxRectangle(mat)); // Output: 8
    }
}
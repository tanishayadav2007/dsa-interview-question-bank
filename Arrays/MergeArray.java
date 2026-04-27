// Problem: Merge Two Sorted Arrays
// Company: Adobe

// Case Study:
// Two departments maintain sorted lists of employee IDs.
// For reporting, these lists need to be merged into a single
// sorted list.

// Problem Statement:
// Given two sorted arrays, merge them into a single sorted array.

// Approach (Two Pointer Method):
// Use three pointers:
// i → for arr1
// j → for arr2
// k → for merged array
//
// Compare elements from both arrays:
// Insert smaller element into new array
// Move corresponding pointer forward
//
// After one array finishes, copy remaining elements

// Time Complexity: O(n + m)
// Space Complexity: O(n + m)

// Example:
// Input: [1, 3, 5], [2, 4, 6]
// Output: [1, 2, 3, 4, 5, 6]
// Explanation:
// Elements are compared one by one and merged in sorted order.

import java.util.*;

public class MergeArray {
    public static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int[] arr_new = new int[n + m];

        int i = 0, j = 0, k = 0;

        // Merge both arrays
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr_new[k++] = arr1[i++];
            } else {
                arr_new[k++] = arr2[j++];
            }
        }

        // Copy remaining elements
        while (i < n) {
            arr_new[k++] = arr1[i++];
        }

        while (j < m) {
            arr_new[k++] = arr2[j++];
        }

        return arr_new;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        int[] result = merge(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
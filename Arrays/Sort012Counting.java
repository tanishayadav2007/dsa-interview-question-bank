// Problem: Sort Array of 0s, 1s, and 2s
// Company: Microsoft

// Case Study:
// A logistics company categorizes packages into three types:
// 0 → Small
// 1 → Medium
// 2 → Large
// To optimize processing, packages must be sorted by type
// so that all small packages come first, followed by medium,
// and then large packages.

// Problem Statement:
// Given an array containing only 0s, 1s, and 2s,
// sort the array in-place (without using extra space).

// Approach (Dutch National Flag Algorithm):
// Use three pointers:
// low → position for next 0
// mid → current element
// high → position for next 2
//
// Traverse the array:
// If element is 0 → swap with low, increment low & mid
// If element is 1 → move mid
// If element is 2 → swap with high, decrement high

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [2, 0, 2, 1, 1, 0]
// Output: [0, 0, 1, 1, 2, 2]


import java.util.*;

public class Sort012Counting {
    public static void sortArray(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;

        // Step 1: Count
        for (int num : arr) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        // Step 2: Overwrite array
        int i = 0;

        while (count0-- > 0) arr[i++] = 0;
        while (count1-- > 0) arr[i++] = 1;
        while (count2-- > 0) arr[i++] = 2;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
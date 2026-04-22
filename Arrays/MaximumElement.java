// Problem: Find Maximum Element
// Company: Tata Consultancy Services (TCS)

// Case Study:
// A retail company stores daily sales data in an array,
// where each element represents revenue for a day.
// The goal is to identify the highest revenue day.

// Problem Statement:
// Given an array of integers, return the maximum element.
// If the array is empty, return an appropriate message.

// Approach:
// Traverse the array and keep updating the maximum value.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [1, 2, 3, 4]
// Output: 4

class Max {
    public int maximum(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return -1;
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}

public class MaximumElement {
    public static void main(String[] args) {
        int[] arr = new int[4];

        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }

        Max ans = new Max();
        System.out.println("Maximum element: " + ans.maximum(arr));
    }
}
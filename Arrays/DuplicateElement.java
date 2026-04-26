// Problem: Find Duplicate Element
// Company: Google

// Case Study:
// A payment system logs transaction IDs in an array.
// Due to a bug, one transaction gets recorded twice.
// Your task is to detect the duplicate ID to prevent fraud or confusion.

// Problem Statement:
// Given an array where one element appears more than once,
// return the duplicate element.

// Approach:
// Use two nested loops to compare each element with others.
// If a match is found, return the duplicate element.

// Time Complexity: O(n^2)
// Space Complexity: O(1)

// Example:
// Input: [1, 3, 4, 2, 2]
// Output: 2

public class DuplicateElement {

    public static void duplicate(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] == arr[j]){
                    System.out.println(arr[i]);
                    return;
                }
            }
        }

        System.out.println("No Duplicate");
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        duplicate(arr);
    }
}
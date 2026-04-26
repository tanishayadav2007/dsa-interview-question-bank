// Problem: Find Missing Number
// Company: Amazon

// Case Study:
// A teacher maintains attendance records using roll numbers from 1 to n.
// However, one student’s record is missing due to a system error.
// The teacher wants to identify the missing roll number.

// Problem Statement:
// Given an array containing numbers from 1 to n with one number missing,
// find the missing number.

// Approach:
// Traverse the array while comparing expected numbers starting from 1.
// If a mismatch is found, return the expected number.
// If all elements match, the missing number is n+1.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [1, 2, 4, 5]
// Output: 3

public class MissingNumber {

    public static int missing(int[] arr){
        int n = arr.length;
        int j = 1;

        for(int i = 0; i < n; i++){
            if(arr[i] != j){
                return j;
            }
            j++;
        }

        return j;
    }

    public static void main(String[] args) {

        int[] arr = {1};
        System.out.println(missing(arr));  // Output: 2

    }
}
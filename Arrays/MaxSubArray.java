// Problem: Maximum Subarray Sum (Kadane’s Algorithm)
// Company: Amazon

// Case Study:
// A financial analyst tracks daily profit and loss in an array.
// They want to find the maximum profit streak, i.e., a continuous
// set of days that gives the highest total profit.

// Problem Statement:
// Given an array of integers, find the maximum sum of a contiguous subarray.

// Approach:
// Use Kadane’s Algorithm.
// Traverse the array while maintaining current sum.
// If current sum becomes negative, reset it to 0.
// Keep track of maximum sum encountered so far.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6

public class MaxSubArray {

    public static int maxSubArray(int[] arr){
        int maxSum = arr[0];
        int currSum = 0;

        for(int i = 0; i < arr.length; i++){

            currSum += arr[i];

            if(currSum > maxSum){
                maxSum = currSum;
            }

            if(currSum < 0){
                currSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(arr));  // Output: 6
    }
}
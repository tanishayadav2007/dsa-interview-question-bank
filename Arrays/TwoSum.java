// Problem: Two Sum Problem
// Company: Facebook

// Case Study:
// An e-commerce platform provides users with a gift card of a fixed amount.
// The system needs to identify two products whose prices add up exactly
// to the gift card value, so users can utilize it fully.

// Problem Statement:
// Given an array of integers and a target value, return the indices
// of two elements such that their sum equals the target.
// If no such pair exists, return "Not Found".

// Approach:
// Use two nested loops to check every pair of elements.
// If a pair sums to target, return their indices.

// Time Complexity: O(n^2)
// Space Complexity: O(1)

// Example:
// Input: [2, 7, 11, 15], target = 9
// Output: [0, 1]


public class TwoSum {
    public static void sum(int[] arr,int target){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    System.out.println("["+i+","+j+"]");
                    return;
                }
            }
        }
        System.out.println("Not Found");
    }
    public static void main(String[] args) {
        int[] arr={2, 7, 11, 15};
        int target=9;
        sum(arr,target);
    }
}

// Difficulty: Medium
//Problem: Next Greater Element
//Company:Flipkart,Microsoft,Adobe,MakeMyTrip

// Problem Statement:
// You are given an array arr[] of integers. The task is to find the next greater element
// for each element of the array in order of their appearance.
//
// The next greater element of an element is the nearest element on the right
// which is greater than the current element.
//
// If there does not exist a next greater element, return -1 for that element.

// Approach:
// We use a Stack to efficiently find the next greater element.
//
// Idea:
// Traverse the array from right to left.
// Use stack to keep track of possible next greater elements.
//
// Steps:
// 1. Initialize an empty stack.
// 2. Traverse array from right to left.
// 3. For each element:
//    - Pop elements from stack while they are smaller or equal to current element.
//    - If stack becomes empty → no greater element → store -1.
//    - Else → top of stack is next greater element.
//    - Push current element into stack.
// 4. Return the result array.

// Time Complexity:
// O(n) → Each element is pushed and popped at most once

// Space Complexity:
// O(n)

// Example:
// Input:
// arr[] = [1, 3, 2, 4]
//
// Output:
// [3, 4, 4, -1]

import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreater(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=-1;
            }
            else{
                result[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;

    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};

        int[] result = nextGreater(arr);

        System.out.println("Output:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

}

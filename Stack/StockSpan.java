// Problem: Stock Span Problem
// Difficulty: Medium
//Company: Flipkart Accolite Amazon Microsoft Samsung Adobe NPCI

// Problem Statement:
// The stock span problem is a financial problem where we have a series of daily stock prices.
// We need to calculate the span of stock price for each day.
//
// The span of the stock’s price on a given day i is defined as the number of
// consecutive days before it (including itself) for which the price of the stock
// is less than or equal to the price on day i.
//
// Given an array arr[] representing daily stock prices, return the span for each day.

// Approach:
// We use a Stack to keep track of indices of useful elements.
//
// Idea:
// - We maintain a stack that stores indices of days.
// - The stack will be maintained in decreasing order of prices.
//
// Steps:
// 1. Create a stack to store indices.
// 2. Traverse the array from left to right.
// 3. For each element:
//    - Pop elements from stack while current price >= price at stack top index.
//    - If stack becomes empty → span = i + 1
//    - Else → span = i - stack.peek()
//    - Push current index into stack
// 4. Return the span array.

// Time Complexity:
// O(n)

// Space Complexity:
// O(n)

// Example:
// Input:
// arr[] = [100, 80, 90, 120]
//
// Output:
// [1, 1, 2, 4]

import java.util.*;
public class StockSpan {
    public static int[] calculateSpan(int[] arr){
        int n=arr.length;
        int[] span=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i]=i+1;
            }
            else{
                span[i]=i-stack.peek();
            }
            stack.push(i);
        }
        return span;
        
    }
    public static void main(String[] args) {
        int[] arr = {100, 80, 90, 120};

        int[] result = calculateSpan(arr);

        System.out.println("Output:");
        for(int val : result){
            System.out.print(val + " ");
        }
    }
}

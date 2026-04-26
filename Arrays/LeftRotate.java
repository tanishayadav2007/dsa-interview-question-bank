// Problem: Left Rotate Array by One
// Company: Tata Consultancy Services (TCS)

// Case Study:
// A scheduling system rotates tasks daily to ensure fair processing.
// Each day, the first task moves to the end,
// and all other tasks shift one position to the left.

// Problem Statement:
// Given an array, perform a left rotation by one position.

// Approach:
// Store the first element, shift all elements to the left by one position,
// and place the stored element at the end of the array.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [1, 2, 3, 4]
// Output: [2, 3, 4, 1]


import java.util.Arrays;

public class LeftRotate {
    public static int[] rotate(int[] arr){
        int n=arr.length;
        int val=arr[0];
        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=val;
        return arr;
    }
    public static void main(String[] args) {
        int[] arr=new int[4];
        for(int i=0;i<4;i++){
            arr[i]=i+1;
        }
        System.out.println(Arrays.toString(rotate(arr)));
    }
}

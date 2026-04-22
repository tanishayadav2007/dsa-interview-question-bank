// Problem: Find Second Maximum Element
// Company: Common Interview Question (Amazon / TCS / Infosys)

// Case Study:
// In data analysis, finding the second highest value helps in identifying
// the runner-up performance or backup metrics when the maximum value is excluded.

// Problem Statement:
// Given an array of integers, find the second largest element.
// If no such element exists, return an appropriate value.

// Approach:
// First, find the maximum element in the array.
// Then, traverse the array again to find the largest element
// that is not equal to the maximum.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [10, 20, 30, 40]
// Output: 30

class SecMax{
    public int maximum(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int smax=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=max && smax<arr[i]){
                smax=arr[i];
            }
        }
        return smax;
    }
}
public class SecondMaximum{
    public static void main(String[] args) {
        SecMax sm=new SecMax();
        int[] arr=new int[4];
        arr[0]=10;
        arr[1]=10;
        arr[2]=10;
        arr[3]=10;
        System.out.println(sm.maximum(arr));
    }
}

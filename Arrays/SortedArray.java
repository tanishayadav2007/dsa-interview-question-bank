// Problem: Check if Array is Sorted
// Company: Tata Consultancy Services (TCS)

// Case Study:
// A database system receives data that is sometimes already sorted.
// To optimize performance, it first checks whether sorting is needed.

// Problem Statement:
// Given an array, determine whether it is sorted in non-decreasing order.

// Approach:
// Traverse the array and compare each element with the next element.
// If any element is greater than the next, the array is not sorted.
// Otherwise, the array is sorted.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [10, 20, 30, 48]
// Output: true

class SortArr{
    public boolean sorted(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
public class SortedArray {
    public static void main(String[] args) {
        int[] arr=new int[4];
        arr[0]=10;
        arr[1]=20;
        arr[2]=30;
        arr[3]=48;
        SortArr sa=new SortArr();
        System.out.println(sa.sorted(arr));
    }
}

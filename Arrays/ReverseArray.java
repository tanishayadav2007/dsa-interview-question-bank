//Problem: Reverse an Array
// Company: IBM

// Case Study:
// A logging system stores events in chronological order.
// However, users want to see the most recent logs first.
// To support this feature, the system needs to reverse the array.

// Problem Statement:
// Given an array, reverse it in-place without using extra space.

// Approach:
// Use two-pointer technique:
// One pointer starts from the beginning (left) and the other from the end (right).
// Swap elements at left and right, then move both pointers towards the center.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [10, 20, 30, 40]
// Output: [40, 30, 20, 10]

class Reverse{
        public void rev(int[] arr){
            int left=0;
            int right=arr.length-1;
            while(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
        }
}
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr=new int[4];
        arr[0]=10;
        arr[1]=20;
        arr[2]=30;
        arr[3]=40;
        System.out.println("Original array:");
        for(int i=0;i<4;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Reverse Array:");
        Reverse ans=new Reverse();
        ans.rev(arr);
    }
}

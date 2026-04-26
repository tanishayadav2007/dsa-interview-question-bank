// Difficulty: Hard
// Company: Flipkart, Amazon, Microsoft, Google, Goldman Sachs

// Problem Statement:
// Given an array arr[] representing heights of blocks,
// find total amount of water that can be trapped after raining.
//
// Each block has width = 1.

// Approach: Two Pointer Technique (Optimal)
//
// Idea:
// Water trapped at any index depends on:
// min(max height on left, max height on right) - current height
//
// Instead of using extra arrays, we use two pointers.
//
// Steps:
// 1. Initialize left = 0, right = n-1
// 2. Maintain leftMax and rightMax
// 3. While left <= right:
//      - If leftMax < rightMax:
//            If arr[left] < leftMax → water += leftMax - arr[left]
//            else update leftMax
//            move left++
//      - Else:
//            If arr[right] < rightMax → water += rightMax - arr[right]
//            else update rightMax
//            move right--

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input:  [3, 0, 1, 0, 4, 0, 2]
// Output: 10

public class TrappingRainWater {

    public static int trap(int[] arr) {

        int left = 0, right = arr.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left <= right) {

            if (leftMax < rightMax) {

                if (arr[left] < leftMax) {
                    water += leftMax - arr[left];
                } else {
                    leftMax = arr[left];
                }

                left++;

            } else {

                if (arr[right] < rightMax) {
                    water += rightMax - arr[right];
                } else {
                    rightMax = arr[right];
                }

                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 0, 4, 0, 2};
        System.out.println(trap(arr)); // Output: 10
    }
}
import java.util.*;

// Problem: 132 Geeky Buildings
// Difficulty: Hard
//Company: Microsoft

// Problem Statement:
// Find if there exists i < j < k such that:
// arr[i] < arr[k] < arr[j]

// Approach:
// Use stack and traverse from right to left
//
// Idea:
// - Keep track of possible "middle" value (arr[k])
// - Use stack to store decreasing elements
//
// Steps:
// 1. Traverse from right to left
// 2. Maintain a variable "third" (represents arr[k])
// 3. If current element < third → found 132 pattern
// 4. While stack not empty and current > stack.peek():
//        update third and pop stack
// 5. Push current element into stack

// Time Complexity: O(n)
// Space Complexity: O(n)

public class GeekyBuildings {

    public static boolean find132pattern(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {

            // Found arr[i] < arr[k]
            if (arr[i] < third) {
                return true;
            }

            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                third = stack.pop();
            }

            stack.push(arr[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 11, 5, 13, 2};
        System.out.println(find132pattern(arr)); // true
    }
}
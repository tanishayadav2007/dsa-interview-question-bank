// Problem: Remove Duplicates from Sorted Array
// Company: Amazon

// Case Study:
// An e-commerce platform stores product IDs in a sorted array,
// but due to system errors, duplicate entries may appear.
// To maintain data integrity, duplicates must be removed.

// Problem Statement:
// Given a sorted array, remove duplicate elements such that each element
// appears only once. Return the updated array length.

// Approach:
// Use two-pointer technique:
// - Pointer j tracks position of unique elements
// - Pointer i scans the array
// When a new unique element is found, increment j and update arr[j]

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [1, 1, 2, 2, 3]
// Output: [1, 2, 3]

class RemoveDup {
    public int remove(int[] arr) {
        if (arr.length == 0) return 0;

        int j = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }

        return j + 1; 
    }
}

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4};

        RemoveDup obj = new RemoveDup();
        int newLength = obj.remove(arr);

        // print unique elements
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

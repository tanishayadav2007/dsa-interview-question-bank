import java.util.Arrays;

/**
 * Problem: Intersection of Two Arrays
 * Company: IBM
 *
 * Description:
 * Given two integer arrays, return their intersection.
 * Each element in the result must be unique.
 *
 * Approach:
 * - Sort both arrays
 * - Use two pointers to traverse
 * - Compare elements and store common ones
 * - Avoid duplicates while inserting
 *
 * Time Complexity: O(n log n + m log m)
 * Space Complexity: O(1) (excluding output array)
 *
 * Example:
 * Input:  arr1 = [1, 2, 2, 1], arr2 = [2, 2]
 * Output: [2]
 */

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] arr1, int[] arr2) {
        // Step 1: Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length;
        int m = arr2.length;

        // Step 2: Temporary array to store result
        int[] temp = new int[Math.min(n, m)];

        int i = 0, j = 0, k = 0;

        // Step 3: Two-pointer traversal
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                // Avoid duplicates
                if (k == 0 || temp[k - 1] != arr1[i]) {
                    temp[k++] = arr1[i];
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Step 4: Return only filled elements
        return Arrays.copyOf(temp, k);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};

        int[] result = intersection(arr1, arr2);
        System.out.println("Intersection: " + Arrays.toString(result));
    }
}
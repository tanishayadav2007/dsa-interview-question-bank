import java.util.*;

/**
 * Problem: Subarray with Given Sum
 * Company: Paytm
 *
 * Description:
 * Given an array of integers and a target sum k,
 * find a contiguous subarray whose sum equals k.
 * If such a subarray exists, return it.
 * Otherwise, return "Not Found".
 *
 * Approach (Sliding Window - for positive numbers):
 * - Use two pointers (start, end)
 * - Expand window by adding elements
 * - Shrink window if sum exceeds k
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Example:
 * Input:  arr = [1, 2, 3, 7, 5], k = 12
 * Output: [2, 3, 7]
 */

public class SubarrayWithGivensum {
    public static String findSubarray(int[] arr, int k) {
        int start = 0, sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > k && start <= end) {
                sum -= arr[start];
                start++;
            }

            if (sum == k) {
                return Arrays.toString(Arrays.copyOfRange(arr, start, end + 1));
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int k = 12;

        System.out.println("Subarray: " + findSubarray(arr, k));
    }
}
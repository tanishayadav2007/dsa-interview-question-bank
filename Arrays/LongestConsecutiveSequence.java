import java.util.Arrays;

/**
 * Problem: Longest Consecutive Sequence
 * Company: Amazon
 *
 * Description:
 * Given an unsorted array, find the length of the longest
 * consecutive elements sequence.
 *
 * Approach (Sorting):
 * - Sort the array
 * - Traverse and count consecutive elements
 * - Skip duplicates
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 *
 * Example:
 * Input:  [100, 4, 200, 1, 3, 2]
 * Output: 4
 */

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr);

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < arr.length; i++) {

            // Skip duplicates
            if (arr[i] == arr[i - 1]) {
                continue;
            }

            // Check consecutive
            else if (arr[i] == arr[i - 1] + 1) {
                currentLength++;
            }

            // Reset count
            else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        return Math.max(maxLength, currentLength);
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        System.out.println("Longest Sequence Length: " + longestConsecutive(arr));
    }
}
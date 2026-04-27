import java.util.Arrays;

/**
 * Problem: Rearrange Positive and Negative Numbers
 * Company: Flipkart
 *
 * Description:
 * Given an array of integers, rearrange it so that positive and negative
 * numbers appear alternately. If one type has extra elements,
 * place them at the end.
 *
 * Approach:
 * - Separate positives and negatives into two arrays
 * - Merge them alternately into result array
 * - Append remaining elements (if any)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Example:
 * Input:  [1, -2, 3, -4]
 * Output: [1, -2, 3, -4]
 */

public class RearrangePositiveNegative {

    public static int[] rearrange(int[] arr) {
        int n = arr.length;

        int[] pos = new int[n];
        int[] neg = new int[n];

        int p = 0, q = 0;

        for (int num : arr) {
            if (num >= 0) {
                pos[p++] = num;
            } else {
                neg[q++] = num;
            }
        }

        int[] result = new int[n];
        int i = 0, j = 0, k = 0;

        while (i < p && j < q) {
            result[k++] = pos[i++];
            result[k++] = neg[j++];
        }

        while (i < p) {
            result[k++] = pos[i++];
        }

        while (j < q) {
            result[k++] = neg[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4};

        int[] result = rearrange(arr);
        System.out.println("Rearranged: " + Arrays.toString(result));
    }
}
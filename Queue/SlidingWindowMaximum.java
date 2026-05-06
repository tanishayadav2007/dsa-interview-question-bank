/**
 * Problem: Sliding Window Maximum (Amazon)
 *
 * Description:
 * Given an array and window size k, return the maximum of each sliding window.
 *
 * Example:
 * Input:  arr = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 *
 * Approach (Deque / Monotonic Queue):
 *
 * - Use a deque to store indices
 * - Keep elements in decreasing order
 *
 * For each element:
 * 1. Remove indices out of window (i - k)
 * 2. Remove smaller elements from back
 * 3. Add current index
 * 4. Front of deque = max of window
 *
 * Key Idea:
 * Maintain a decreasing monotonic deque → O(1) access to max.
 *
 * Complexity:
 * Time: O(n)
 * Space: O(k)
 */

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>(); 
        int r = 0;

        for (int i = 0; i < n; i++) {

            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                res[r++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;

        int[] result1 = maxSlidingWindow(nums1, k1);

        System.out.println("Output 1: " + Arrays.toString(result1));

        int[] nums2 = {1};
        int k2 = 1;

        int[] result2 = maxSlidingWindow(nums2, k2);

        System.out.println("Output 2: " + Arrays.toString(result2));
    }
}
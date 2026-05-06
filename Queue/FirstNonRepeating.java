/**
 * Problem: First Non-Repeating Character in Stream (Flipkart)
 *
 * Description:
 * Given a stream of characters, print the first non-repeating
 * character at each step. If none exists, print -1.
 *
 * Example:
 * Input:  "abacadabrabrac"
 * Output: a a b b b b b b b b r r r r
 *
 * ---------------------------------------
 *
 * Approach (Queue + Frequency):
 *
 * - Use a queue to maintain order of characters
 * - Use frequency array to track counts
 *
 * For each character:
 * 1. Increase frequency
 * 2. Add to queue
 * 3. Remove front while freq > 1
 * 4. Print front or -1 if empty
 *
 * ---------------------------------------
 *
 * Key Idea:
 * Queue keeps order, frequency ensures validity.
 *
 * ---------------------------------------
 *
 * Complexity:
 * Time: O(n)
 * Space: O(1) / O(26)
 */

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {
    public static void firstNonRepeating(String s) {

        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            freq[ch - 'a']++;

            q.offer(ch);

            // remove invalid (repeating) characters from front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }
    public static void main(String[] args) {
        String s = "abacadabrabrac";
        firstNonRepeating(s);
    }
}

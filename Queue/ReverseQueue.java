/**
 * Problem: Reverse a Queue (Goldman Sachs)
 *
 * Description:
 * Reverse elements of a queue using only queue operations.
 * No arrays, stacks, or extra DS logic allowed (only queues).
 *
 * Approach:
 * - Use an auxiliary queue (q2)
 * - Repeatedly:
 *      rotate q1 (size - 1 times)
 *      remove last element → push to q2
 * - Transfer q2 back to q1
 *
 * Key Idea:
 * - (size - 1) rotations bring last element to front
 * - Extract it and store in q2 → builds reversed order
 *
 * Complexity:
 * - Time: O(n²)
 * - Space: O(n)
 *
 * Example:
 * Input:  1 2 3 4
 * Output: 4 3 2 1
 *
 * Input:  5
 * Output: 5
 */


import java.util.LinkedList;
import java.util.Queue;
public class ReverseQueue {
    public static void reverse(Queue<Integer> q1){
        Queue<Integer> q2=new LinkedList<>();
        while(!q1.isEmpty()){
            int size=q1.size();
            for(int i=0;i<size-1;i++){
                q1.add(q1.remove());
            }
            q2.add(q1.remove());
        }
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        reverse(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}

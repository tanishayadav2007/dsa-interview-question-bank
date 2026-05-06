/**
 * Problem: Queue Implementation using Two Stacks
 *
 * Description:
 * Implement a queue using two stacks such that it follows FIFO (First In First Out).
 * The queue should support standard operations like enqueue and dequeue.
 *
 * Operations:
 * - enqueue(x): Insert element x into the queue
 * - dequeue(): Remove and return the front element of the queue
 *
 * Approach:
 * - Use two stacks:
 *      s1 → used for enqueue operations
 *      s2 → used for dequeue operations
 *
 * - On enqueue(x):
 *      Push element into s1
 *
 * - On dequeue():
 *      If both stacks are empty → Underflow
 *      If s2 is empty:
 *          Transfer all elements from s1 to s2 (reverses order)
 *      Pop and return element from s2
 *
 * - This ensures FIFO behavior using LIFO stacks
 *
 * Edge Cases:
 * - Underflow: When both s1 and s2 are empty
 *
 * Time Complexity:
 * - enqueue: O(1)
 * - dequeue:
 *      Amortized → O(1)
 *      Worst case → O(n) (when transferring elements)
 *
 * Space Complexity:
 * - O(n), where n is number of elements in queue
 *
 * Example:
 * Input:
 * enqueue(1), enqueue(2), dequeue(), enqueue(3), dequeue(), dequeue()
 *
 * Output:
 * 1
 * 2
 * 3
 *
 * Input:
 * enqueue(5), dequeue(), dequeue()
 *
 * Output:
 * 5
 * -1 (Underflow)
 */

import java.util.*;
class MyQueue{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    void enqueue(int x){
        s1.push(x);
    }
    int dequeue(){
        if(s1.isEmpty() && s2.isEmpty()){
            return -1;
        }
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
public class QueueUsingStacks{
    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
    }
}
/**
 * Problem: Queue Implementation using Array (Linear Queue)
 *
 * Description:
 * Implement a queue using a fixed-size array that follows FIFO (First In First Out).
 * The queue supports insertion at the rear and deletion from the front.
 *
 * Operations:
 * - enqueue(x): Insert element x at the rear of the queue
 * - dequeue(): Remove and return the front element
 * - front(): Return the front element without removing it
 *
 * Approach:
 * - Use an array to store elements
 * - Maintain two pointers:
 *      front → points to the first element
 *      rear  → points to the last inserted element
 * - Initially:
 *      front = 0
 *      rear = -1
 * - On enqueue:
 *      Increment rear and insert element
 * - On dequeue:
 *      Return element at front and increment front
 *
 * Edge Cases:
 * - Overflow: When rear reaches capacity - 1
 * - Underflow: When front > rear (queue becomes empty)
 *
 * Time Complexity:
 * - enqueue: O(1)
 * - dequeue: O(1)
 * - front:   O(1)
 *
 * Space Complexity:
 * - O(n), where n is the capacity of the queue
 *
 * Limitation:
 * - This is a linear queue, so space is wasted after dequeue operations.
 * - Example: freed positions at the front cannot be reused.
 * - Solution: Use Circular Queue to optimize space.
 *
 * Example:
 * Input:
 * enqueue(10), enqueue(20), front(), dequeue(), enqueue(30), front()
 *
 * Output:
 * 10
 * 10
 * 20
 *
 * Input:
 * enqueue(5), dequeue(), dequeue()
 *
 * Output:
 * 5
 * Underflow / -1
 */

class Queue {
    int[] queue;
    int front, rear, capacity;

    Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    boolean isEmpty() {
        return front > rear;
    }

    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        queue[++rear] = item;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        return queue[front++];
    }

    int front() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }
}
public class QueueUsingArray {
    public static void main(String[] args) {
        Queue queue=new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.front();
    }
}

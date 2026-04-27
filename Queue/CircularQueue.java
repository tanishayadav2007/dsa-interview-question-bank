/**
 * Problem: Circular Queue using Array
 *
 * Description:
 * Implement a circular queue using a fixed-size array. In a circular queue,
 * the last position is connected back to the first position to form a circle.
 * This allows efficient utilization of space by reusing empty positions.
 *
 * Operations:
 * - enqueue(x): Insert an element at the rear of the queue
 * - dequeue(): Remove and return the front element
 * - front(): Return the front element without removing it
 * - display(): Print all elements in the queue
 *
 * Approach:
 * - Use an array to store elements
 * - Maintain two pointers:
 *      front → points to the first element
 *      rear  → points to the last inserted element
 * - Initially:
 *      front = -1, rear = -1
 * - Use modulo (%) operation to wrap around the array
 *
 * Time Complexity:
 * - enqueue: O(1)
 * - dequeue: O(1)
 * - front:   O(1)
 *
 * Space Complexity:
 * - O(n), where n is the size of the queue
 *
 * Edge Cases:
 * - Overflow: When queue is full → (rear + 1) % size == front
 * - Underflow: When queue is empty → front == -1
 *
 * Example:
 * Input:
 * enqueue(10), enqueue(20), enqueue(30), enqueue(40), enqueue(50),
 * dequeue(), dequeue(), enqueue(60), enqueue(70), front()
 *
 * Output:
 * 10
 * 20
 * 30
 */

class Queue{
    int[] queue;
    int front=-1;
    int rear=-1;
    int size;

    Queue(int size){
        this.size=size;
        queue=new int[size];
    }
    void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        if(front==-1){
            front=0;
        }
        rear=(rear+1)%size;
        queue[rear]=value;
        System.out.println(value+" inserted");
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        int value = queue[front];

        if(front == rear){
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return value;
    }
    void display(){
        if(front==-1){
            System.out.println("Queue is Empty");
            return;
        }
        int i=front;
        while (true) { 
            System.out.println(queue[i]+" ");
            if(i==rear){
                break;
            }
            i=(i+1)%size;
        }
        System.out.println();
    }
    boolean isEmpty(){
        return front==-1;
    }
    boolean isFull(){
        return (rear+1)%size==front;
    }
    int front(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }

}
public class CircularQueue {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        // Enqueue elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // This should show Overflow
        q.enqueue(60);

        // Dequeue elements
        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20

        // Enqueue again to check circular nature
        q.enqueue(60);
        q.enqueue(70);

        // Display front element
        System.out.println(q.front()); // 30

        // Dequeue remaining elements
        System.out.println(q.dequeue()); // 30
        System.out.println(q.dequeue()); // 40
        System.out.println(q.dequeue()); // 50
        System.out.println(q.dequeue()); // 60
        System.out.println(q.dequeue()); // 70

    }
}

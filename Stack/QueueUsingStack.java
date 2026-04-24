// Problem: Queue Implementation Using Two Stacks
// Company:Flipkart, Morgan Stanley, Accolite, Amazon, Microsoft, MakeMyTrip, Oracle, Walmart, Goldman Sachs

// Problem Statement:
// Implement a Queue using two stacks such that it supports standard queue operations:
// 1. enqueue(x) → Insert element into queue
// 2. dequeue() → Remove element from queue
// 3. peek() → Get front element
// 4. isEmpty() → Check if queue is empty

// Approach:
// A queue follows FIFO (First In First Out) order, while stacks follow LIFO.
// To simulate queue behavior using stacks:
// 
// We use two stacks:
// 1. s1 → Used for enqueue operation
// 2. s2 → Used for dequeue and peek operations
//
// Steps:
// 1. For enqueue(x): Push element into s1.
// 2. For dequeue():
//    - If both stacks are empty → Queue is empty.
//    - If s2 is empty → Transfer all elements from s1 to s2.
//    - Pop from s2.
// 3. For peek():
//    - Same as dequeue, but return top without removing.
// 4. For isEmpty():
//    - Return true if both s1 and s2 are empty.

// Time Complexity:
// enqueue() → O(1)
// dequeue() → Amortized O(1)
// peek() → Amortized O(1)

// Space Complexity: O(n)

// Example:
// Input:
// enqueue(1), enqueue(2), enqueue(3), enqueue(4)
// dequeue() → returns 1
// peek() → returns 2
//
// Output:
// 1
// 2


import java.util.*;
class Queue{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public void enqueue(int x){
        s1.push(x);
    }
    public  int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Full");
            return -1;
        }
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();

    }
    public int peek(){
        if(isEmpty()){
            System.out.println();
            return -1;
        }
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }

}
public class QueueUsingStack {
    public static void main(String[] args) {
         Queue q = new Queue();  

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.println(q.dequeue());
        System.out.println(q.peek());    
    }
}

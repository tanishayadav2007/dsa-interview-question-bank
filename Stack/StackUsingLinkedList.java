// Problem: Stack Implementation Using Linked List
// Company: Amazon / Microsoft / Flipkart (Common Interview Question)

// Problem Statement:
// Implement a Stack using a Linked List. The stack should dynamically grow
// and support the following operations:
//
// (i) push(x): Insert element x at the top of the stack.
// (ii) pop(): Remove the top element from the stack.
// (iii) peek(): Return the top element if not empty, else return -1.
// (iv) isEmpty(): Return true if stack is empty, else false.
// (v) size(): Return the number of elements in the stack.
//
// Queries Format:
// 1 x → push(x)
// 2   → pop()
// 3   → peek()
// 4   → isEmpty()
// 5   → size()

// Approach:
// We use a singly linked list to implement the stack.
// The 'top' pointer represents the top of the stack.
//
// Steps:
// 1. push(x):
//    - Create a new node.
//    - Point its next to current top.
//    - Update top to new node.
//    - Increment size.
//
// 2. pop():
//    - If stack is empty → return -1.
//    - Store top value.
//    - Move top to next node.
//    - Decrement size.
//    - Return stored value.
//
// 3. peek():
//    - If empty → return -1.
//    - Return top value.
//
// 4. isEmpty():
//    - Return true if top == null.
//
// 5. size():
//    - Maintain a counter variable to track size.

// Time Complexity:
// push() → O(1)
// pop() → O(1)
// peek() → O(1)
// isEmpty() → O(1)
// size() → O(1)

// Space Complexity: O(n)

// Example:
// Input:
// push(1), push(2), push(3)
// pop() → returns 3
// peek() → returns 2
// size() → returns 2
//
// Output:
// 3
// 2
// 2


class Solution{
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    Node top=null;
    int val;
    public void push(int val){
        Node node=new Node(val);
        node.next=top;
        top=node;
        System.out.println(top.val+" Pushed");
    }
    public void pop(){
        if(isEmpty()){
            System.out.println("Can't pop stack is empty");
        }
        else{
            System.out.println(top.val+" is popped");
            top=top.next;
        }
    }
    public void peek(){
        if(isEmpty()){
            System.out.println("Can't pop stack is empty");
        }
        else{
            System.out.println(top.val+" is at top");
        }
    }
    public boolean isEmpty(){
        return top==null;
    }
    public boolean isFull(){
        return false;
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        Solution stack=new Solution();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.peek();
    }
}

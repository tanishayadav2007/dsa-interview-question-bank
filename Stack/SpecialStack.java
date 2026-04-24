// Problem: Special Stack (Get Minimum Element)
// Company: Amazon / Microsoft / Flipkart / Goldman Sachs / Adobe

// Problem Statement:
// Design a Special Stack data structure that supports all standard stack
// operations and an additional operation getMin() which returns the
// minimum element in the stack.
//
// (i) push(x): Insert element x at the top of the stack.
// (ii) pop(): Remove the top element from the stack.
// (iii) isEmpty(): Return true if stack is empty, else false.
// (iv) isFull(): Return true if stack is full (not applicable here).
// (v) getMin(): Return the minimum element in the stack.

// Approach:
// We implement the stack using a singly linked list.
// The 'top' pointer represents the top of the stack.
//
// Steps:
// 1. push(x):
//    - Create a new node.
//    - Point its next to current top.
//    - Update top to new node.
//
// 2. pop():
//    - If stack is empty → print message.
//    - Move top to next node.
//
// 3. isEmpty():
//    - Return true if top == null.
//
// 4. isFull():
//    - Always return false (dynamic memory).
//
// 5. getMin():
//    - Traverse the stack from top to bottom.
//    - Keep track of minimum value.
//    - Return the minimum element.

// Time Complexity:
// push() → O(1)
// pop() → O(1)
// getMin() → O(n) 

// Space Complexity: O(n)

// Example:
// Input:
// push(18), push(19), push(29), push(15), push(16)
//
// getMin() → returns 15
//
// Output:
// 15
//
// Input:
// push(34), push(335), push(1814), push(86)
//
// getMin() → returns 34
//
// Output:
// 34


import java.util.*;
class Solution{
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    public int getMin(){
        if (isEmpty()) {
            return -1;
        }

        Node temp = top;
        int min = temp.val;

        while (temp != null) {
            if (temp.val < min) {
                min = temp.val;
            }
            temp = temp.next;
        }

        return min;
    }
    Node top=null;

    public void push(int val){
        Node node=new Node(val);
        if(isFull()){
            System.out.println("Stack is full");
        }
        node.next=top;
        top=node;
        System.out.println(top.val+" is pushed");
    }
    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        System.out.println(top.val+" is popped");
        top=top.next;
    }
    public boolean isFull(){
        return false;
    }
    public boolean isEmpty(){
        return top==null;
    }
    
}

public class SpecialStack{
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        Solution s=new Solution();
        s.push(18);
        s.push(19);
        s.push(29);
        s.push(15);
        s.push(16);

        System.out.println("Minimum Element: "+s.getMin());

    }
}
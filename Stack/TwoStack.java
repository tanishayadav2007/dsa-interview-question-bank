// Problem: Two Stacks in an Array
// Company: Amazon / Microsoft / Flipkart / Goldman Sachs

// Problem Statement:
// Implement two stacks in a single array efficiently.
// The array has a fixed size, and both stacks share the same space.
//
// (i) twoStacks: Initialize the array and pointers.
// (ii) push1(x): Push element into stack1.
// (iii) push2(x): Push element into stack2.
// (iv) pop1(): Pop element from stack1, return -1 if empty.
// (v) pop2(): Pop element from stack2, return -1 if empty.

// Approach:
// Use a single array and two pointers:
//
// - stack1 starts from left (index 0) and grows forward
// - stack2 starts from right (index n-1) and grows backward
//
// Maintain:
// top1 → for stack1 (initially -1)
// top2 → for stack2 (initially n)
//
// Key Idea:
// Both stacks grow towards each other.
// Overflow occurs when top1 + 1 == top2

// Steps:
// 1. push1(x):
//    - Check if space is available (top1 + 1 < top2)
//    - Increment top1 and insert x
//
// 2. push2(x):
//    - Check if space is available (top1 + 1 < top2)
//    - Decrement top2 and insert x
//
// 3. pop1():
//    - If top1 == -1 → return -1
//    - Return arr[top1] and decrement top1
//
// 4. pop2():
//    - If top2 == n → return -1
//    - Return arr[top2] and increment top2

// Time Complexity:
// push1() → O(1)
// push2() → O(1)
// pop1() → O(1)
// pop2() → O(1)

// Space Complexity: O(n)

// Example:
// Input:
// push1(2), push1(3), push2(4)
// pop1() → returns 3
// pop2() → returns 4
// pop2() → returns -1
//
// Output:
// [3, 4, -1]
//
// Input:
// push1(1), push2(2), pop1(), push1(3), pop1(), pop1()
//
// Output:
// [1, 3, -1]


import java.util.*;

class Stacks {
    int[] arr;
    int size;
    int top1, top2;

    // (i) Initialize two stacks
    Stacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = n;
    }

    // (ii) Push in Stack 1
    void push1(int x) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow in Stack1");
            return;
        }
        arr[++top1] = x;
    }

    // (iii) Push in Stack 2
    void push2(int x) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow in Stack2");
            return;
        }
        arr[--top2] = x;
    }

    // (iv) Pop from Stack 1
    int pop1() {
        if (top1 == -1) {
            return -1;
        }
        return arr[top1--];
    }

    // (v) Pop from Stack 2
    int pop2() {
        if (top2 == size) {
            return -1;
        }
        return arr[top2++];
    }
}

public class TwoStack {
    public static void main(String[] args) {
        Stacks ts = new Stacks(5);

        ts.push1(2);
        ts.push1(3);
        ts.push2(4);

        System.out.println("Pop1: " + ts.pop1()); // 3
        System.out.println("Pop2: " + ts.pop2()); // 4
        System.out.println("Pop2: " + ts.pop2()); // -1
    }
}
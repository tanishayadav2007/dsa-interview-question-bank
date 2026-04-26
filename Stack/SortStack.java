import java.util.*;

// Problem: Sort a Stack
// Difficulty: Medium
// Company: : Amazon Microsoft Goldman SachsIntuit Yahoo IBM Kuliza

// Problem Statement:
// Given a stack of integers st[], sort the stack in ascending order.
// The smallest element should be at the bottom and the largest at the top.

// Approach:
// We use an auxiliary stack to store elements in sorted order.
//
// Idea:
// - Pop element from original stack
// - Insert it into correct position in temp stack
// - Move elements back temporarily if needed

// Steps:
// 1. Create an empty temp stack
// 2. While original stack is not empty:
//    - Pop element (curr)
//    - While temp stack is not empty AND top > curr:
//         Move elements back to original stack
//    - Push curr into temp stack
// 3. temp stack will be sorted

// Time Complexity:
// O(n^2)

// Space Complexity:
// O(n)

// Example:
// Input:
// st[] = [1, 2, 3]
//
// Output (top to bottom):
// 3 2 1

public class SortStack{

    public static Stack<Integer> sortStack(Stack<Integer> st) {
        Stack<Integer> tempStack = new Stack<>();

        while (!st.isEmpty()) {
            int curr = st.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > curr) {
                st.push(tempStack.pop());
            }

            tempStack.push(curr);
        }

        return tempStack;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);

        Stack<Integer> sorted = sortStack(st);

        System.out.println("Sorted Stack (Top to Bottom):");
        while (!sorted.isEmpty()) {
            System.out.print(sorted.pop() + " ");
        }
    }
}

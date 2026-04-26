import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

// Problem: Stack using Queue
// Difficulty: Medium
// Company: Accolite, Amazon, Microsoft, OYO Rooms, Snapdeal

// Problem Statement:
// Implement a Stack using Queue with queries[][] format.
//
// Queries:
// 1 x → push(x)
// 2   → pop()
// 3   → top()
// 4   → size()

// Approach:
// We use a single queue and rotate it after every push
// so that the last inserted element comes to the front.

// Time Complexity:
// push() → O(n)
// pop() → O(1)
// top() → O(1)
// size() → O(1)

// Space Complexity:
// O(n)

// Example:
// Input:
// queries[][] = [[1,5],[1,3],[1,4],[3],[2],[4]]
//
// Output:
// [4, 2]

class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
        int size = q.size();

        // Rotate queue
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    public void pop() {
        if (!q.isEmpty()) {
            q.remove();
        }
    }

    public int top() {
        if (q.isEmpty()) return -1;
        return q.peek();
    }

    public int size() {
        return q.size();
    }
}

public class StackUsingQueue {

    public static void main(String[] args) {

        int[][] queries = {
            {1, 5},
            {1, 3},
            {1, 4},
            {3},
            {2},
            {4}
        };

        MyStack st = new MyStack();
        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {
                st.push(q[1]);
            } 
            else if (q[0] == 2) {
                st.pop();
            } 
            else if (q[0] == 3) {
                result.add(st.top());
            } 
            else if (q[0] == 4) {
                result.add(st.size());
            }
        }

        // Print output
        System.out.println(result);
    }
}
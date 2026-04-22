// Problem: Detect Cycle in a Linked List
// Company: IBM

// Problem Statement:
// Given a singly linked list, determine whether it contains a cycle.
// A cycle occurs when a node’s next pointer points to a previously visited node,
// forming a loop where traversal never ends.

// Approach:
// Use Floyd’s Cycle Detection Algorithm (Tortoise and Hare).
// Initialize two pointers: slow and fast.
// Move slow by one step and fast by two steps.
// If they meet at any point, a cycle exists.
// If fast reaches null, no cycle exists.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 2 (cycle)
// Output: True

class Cycle {
    Node head;

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void detect() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }

    public void createCycleToValue(int val) {
    if (head == null) return;

    Node temp = head;
    Node target = null;

    while (temp != null) {
        if (temp.val == val) {
            target = temp;
        }
        temp = temp.next;
    }

    temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }

    if (target != null) {
        temp.next = target;
    }
}
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}

public class DetectCycleSLL{
    public static void main(String[] args) {
        Cycle list = new Cycle();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.createCycleToValue(2);

        list.detect(); 
    }
}


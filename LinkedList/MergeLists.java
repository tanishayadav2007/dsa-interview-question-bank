// Series: DSA Interview Question Bank

// Problem: Merge Two Sorted Linked Lists
// Company: Amazon

// Problem Statement:
// Given two sorted linked lists, merge them into a single sorted linked list
// without creating new nodes (reuse existing nodes).

// Approach:
// Compare nodes of both lists and link the smaller node to the result list.
// Maintain a pointer to build the merged list.
// Continue until one list is exhausted, then attach the remaining nodes
// from the other list.

// Time Complexity: O(n + m)
// Space Complexity: O(1)

// Example:
// Input:
// List1: 1 -> 3 -> 5
// List2: 2 -> 4 -> 6
// Output:
// 1 -> 2 -> 3 -> 4 -> 5 -> 6

class MergeLists {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node merge(Node l1, Node l2) {
        // handle edge cases
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node head; // result head

        // decide starting node
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        Node temp = head;

        // merge
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        // attach remaining nodes
        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;

        return head;
    }

    // helper to print list
    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public static void main(String[] args) {

        // List1: 1 → 3 → 5
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        // List2: 2 → 4 → 6
        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node result = merge(l1, l2);

        display(result);
    }
}

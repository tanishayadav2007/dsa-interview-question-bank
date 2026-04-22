// Problem: Reverse a Singly Linked List
// Company: Tata Consultancy Services (TCS)

// Problem Statement:
// Given the head of a singly linked list, reverse the list such that
// the direction of all links between nodes is reversed.
// After reversal:
// - The last node becomes the new head
// - Each node points to its previous node

// Approach:
// Use three pointers: prev, curr, and next.
// Traverse the list and reverse the links by making each node point
// to its previous node instead of the next.
// Finally, update head to the last processed node (prev).

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 5
// Output: 5 -> 4 -> 3 -> 2 -> 1


class Reverse {
    Node head;
    public void insert(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next_Node;

        while (curr != null) {
            next_Node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_Node;
        }
        head = prev;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}

public class ReverseLL {
    public static void main(String[] args) {
        Reverse list = new Reverse();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.print("Original: ");
        list.display();

        list.reverse();

        System.out.print("Reversed: ");
        list.display();
    }
}
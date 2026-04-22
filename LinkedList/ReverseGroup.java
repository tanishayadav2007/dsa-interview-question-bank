// Problem: Reverse Nodes in Groups of K
// Company: Amazon

// Problem Statement:
// Given a singly linked list, reverse the nodes of the list k at a time.
// If the number of nodes is not a multiple of k, the remaining nodes
// at the end should remain as they are.

// Approach:
// Reverse the first k nodes using standard pointer reversal.
// After reversing, recursively call the function for the remaining list.
// Connect the last node of the reversed group (original head)
// to the result of the next reversed group.

// Time Complexity: O(n)
// Space Complexity: O(n/k)  // due to recursion stack

// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2
// Output: 2 -> 1 -> 4 -> 3 -> 5

class Reverse {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public Node reverseK(Node head, int k) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseK(next, k);
        }

        return prev;
    }
}

public class ReverseGroup {
    public static void main(String[] args) {
        Reverse list = new Reverse();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);

        list.display();

        int k = 2;
        list.head = list.reverseK(list.head, k);

        list.display();
    }
}
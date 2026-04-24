// Problem: Add Two Numbers Represented by Linked Lists
// Company: Amazon

// Problem Statement:
// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each node contains a single digit.
// Add the two numbers and return the sum as a linked list.

// Approach:
// 1. Create a dummy node to store the result.
// 2. Traverse both lists simultaneously.
// 3. At each step:
//    - Add corresponding digits along with carry.
//    - Store (sum % 10) in new node.
//    - Update carry = sum / 10.
// 4. If one list ends, continue with the other.
// 5. If carry remains at the end, add a new node.
// 6. Return dummy.next as the result.

// Time Complexity: O(max(n, m))
// Space Complexity: O(max(n, m))  (for result list)

// Example:
// Input:  (2 -> 4 -> 3), (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

// Explanation:
// Number1 = 342
// Number2 = 465
// Sum = 807
// Result (reversed) = 7 -> 0 -> 8

// Edge Cases:
// - Lists of different lengths
// - Carry at the end (e.g., 9 + 1 → extra node)
// - One list is null

// Key Concept:
// Perform digit-by-digit addition just like manual addition.

class AddTwoNumbers {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;

    // Insert at end
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

    // Display list
    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Add two linked lists
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new Node(sum % 10);
            carry = sum / 10;

            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        // First number: 2 -> 4 -> 3
        AddTwoNumbers list1 = new AddTwoNumbers();
        list1.insert(2);
        list1.insert(4);
        list1.insert(3);

        // Second number: 5 -> 6 -> 4
        AddTwoNumbers list2 = new AddTwoNumbers();
        list2.insert(5);
        list2.insert(6);
        list2.insert(4);

        System.out.print("List 1: ");
        list1.display(list1.head);

        System.out.print("List 2: ");
        list2.display(list2.head);

        Node result = addTwoNumbers(list1.head, list2.head);

        System.out.print("Result: ");
        list1.display(result);
    }
}
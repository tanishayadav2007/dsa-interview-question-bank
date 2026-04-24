// Problem: Detect Start of Cycle in a Linked List
// Company: Amazon

// Problem Statement:
// Given a singly linked list, return the node where the cycle begins.
// If there is no cycle, return null.

// Approach:
// Use Floyd’s Cycle Detection Algorithm (Tortoise and Hare).
// Step 1: Use two pointers (slow and fast) to detect cycle.
//         Move slow by 1 step and fast by 2 steps.
//         If they meet, a cycle exists.
// Step 2: Move slow pointer back to head.
//         Keep fast pointer at meeting point.
//         Move both one step at a time.
//         The point where they meet again is the start of the cycle.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 5
//               ↑         ↓
//               ← ← ← ← ←
// Output: 2

class DetectCycleStart {

    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

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

    // Create cycle at given position (1-based index)
    public void createCycle(int pos) {
        if (pos == 0) return;

        Node temp = head;
        Node cycleNode = null;
        int count = 1;

        while (temp.next != null) {
            if (count == pos) {
                cycleNode = temp;
            }
            temp = temp.next;
            count++;
        }
        temp.next = cycleNode; // create cycle
    }

    // Detect start of cycle
    public Node detectCycleStart() {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find start
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // start node
            }
        }

        return null; // no cycle
    }

    public static void main(String[] args) {
        DetectCycleStart list = new DetectCycleStart();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.createCycle(2); // cycle starts at node with value 2

        Node result = list.detectCycleStart();

        if (result != null) {
            System.out.println("Cycle starts at node: " + result.val);
        } else {
            System.out.println("No cycle found");
        }
    }
}

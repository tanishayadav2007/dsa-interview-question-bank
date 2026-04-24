// Problem: Length of Loop in a Linked List
// Company: Fidelity Investments

// Problem Statement:
// Given a singly linked list, determine if a loop (cycle) exists.
// If a loop is present, return the number of nodes in the loop.
// If no loop exists, return 0.

// Approach (Floyd’s Cycle Detection Algorithm):
// 1. Use two pointers:
//    - slow moves one step at a time
//    - fast moves two steps at a time
// 2. If slow and fast meet → a loop exists.
// 3. Once a loop is detected:
//    - Keep one pointer fixed
//    - Move the other pointer one step at a time
//    - Count the number of steps until it reaches the same node again
// 4. Return the count as the loop length.
// 5. If no loop is detected, return 0.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 5
//                 ↑       ↓
//                 ← ← ← ←
// Loop starts at position 2

// Output: 4

// Explanation:
// Loop nodes are: 2 -> 3 -> 4 -> 5 → back to 2
// Total nodes in loop = 4

// Edge Cases:
// - Empty list → return 0
// - No loop → return 0
// - Single node with self-loop → return 1


class Length{
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
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }
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
    public int lengthOfLoop() {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // loop detected

                // Step 2: Count loop length
                int count = 1;
                Node temp = slow.next;

                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }

                return count;
            }
        }

        return 0; // no loop
    }
}
public class LoopLength {
    public static void main(String[] args) {
        Length list=new Length();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.createCycle(2); // cycle starts at node with value 2

        int result = list.lengthOfLoop();

        System.out.println("length of cycle:"+result);
    }
}

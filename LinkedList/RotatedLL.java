// Problem: Rotate Linked List by K Positions (Right Rotation)
// Company: Common Interview Problem (Amazon, Microsoft, etc.)

// Problem Statement:
// Given a singly linked list, rotate the list to the right by k positions.
// Rotation means moving the last k nodes to the front of the list.

// Approach:
// 1. Handle edge cases:
//    - If list is empty, has one node, or k = 0 → return as it is.
// 2. Traverse the list to find:
//    - Length of the list
//    - Last node
// 3. Reduce k using modulo:
//    - k = k % length (to avoid unnecessary rotations)
// 4. Convert list into circular linked list:
//    - lastNode.next = head
// 5. Find new tail:
//    - Move (length - k) steps from head
// 6. Set new head:
//    - head = newTail.next
// 7. Break the circle:
//    - newTail.next = null

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 2
// Output: 5 -> 6 -> 1 -> 2 -> 3 -> 4

// Input: 10 -> 20 -> 30, k = 1
// Output: 30 -> 10 -> 20

// Key Concept:
// Rotation = Make circular + Break at correct position

// Edge Cases:
// - Empty list → return null
// - Single node → no change
// - k multiple of length → no change

class Rotate{
    Node head;
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
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
    public void insert(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }
    public void rotateList(int k) {
    if (head == null || head.next == null || k == 0) return;

    Node temp = head;
    int length = 1;
    while (temp.next != null) {
        temp = temp.next;
        length++;
    }

    k = k % length;
    if (k == 0) return;

    // Step 3: Make circular
    temp.next = head;

    // Step 4: Find new tail (length - k)
    int steps = length - k;
    Node newTail = head;

    for (int i = 1; i < steps; i++) {
        newTail = newTail.next;
    }

    // Step 5: Set new head
    head = newTail.next;

    // Step 6: Break the circle
    newTail.next = null;
    }
}
public class RotatedLL {
    public static void main(String[] args) {
        Rotate list=new Rotate();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);

        list.display();
    }
}

// Problem: Delete Node at Given Position in a Linked List
// Company: Capgemini

// Problem Statement:
// Given a singly linked list, delete the node at a specific position (1-based index).
// If the position is invalid or the list is empty, do nothing or handle gracefully.

// Approach:
// 1. If the list is empty, return.
// 2. If position is 1, update head to head.next.
// 3. Traverse the list to reach (position - 1) node.
// 4. Update links to skip the target node:
//    prev.next = prev.next.next
// 5. Handle cases where position is out of bounds.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4, pos = 2
// Output: 1 -> 3 -> 4

// Input: 10 -> 20 -> 30, pos = 1
// Output: 20 -> 30

// Input: NULL, pos = 1
// Output: NULL


class Delete{
    Node head;
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
    public void display(){
    
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }
    public void remove(int pos) {
        if(head==null){
            System.out.println("Empty LL");
            return;
        }
        if (pos == 1) {
        head = head.next;
        return;
        }
    
        Node temp=head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Invalid position");
        return;
        }
        temp.next=temp.next.next;
    }
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
}
public class DeleteAtPos {
    public static void main(String[] args) {
        Delete list=new Delete();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();
        list.remove(2);
        list.display();
    }
}

// Problem: Insert Node at Given Position in Linked List
// Company: Tata Consultancy Services (TCS)

// Problem Statement:
// Given a singly linked list, insert a node with a given value at a specified position.

// Rules:
// - Positions are 1-based indexing
// - If position = 1 → insert at beginning
// - Otherwise → insert at the given position by adjusting links

// Approach:
// Traverse the linked list until (position - 1) node.
// Create a new node.
// Adjust pointers:
//   newNode.next = temp.next
//   temp.next = newNode

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input:  pos = 3, val = 3
// List:   1 -> 2 -> 4
// Output: 1 -> 2 -> 3 -> 4


class Insertion{
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
    public void InsertPos(int pos,int val){
        Node  temp=head;
        Node node=new Node(val);
        for(int i=1;i<pos-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
    }
}
public class InsertAtPos {
    public static void main(String[] args) {
        Insertion list=new Insertion();
        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(5);
        list.display();
        list.InsertPos(3, 3);
        list.display();
    }
}

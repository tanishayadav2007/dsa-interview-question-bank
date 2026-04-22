// Problem: Find the Middle Element of a Linked List
// Company: Capgemini

// Problem Statement:
// Given a singly linked list, return the middle node.
// Rules:
// - If the list has an odd number of nodes → return the exact middle
// - If the list has an even number of nodes → return the second middle node

// Approach:
// First, traverse the linked list to calculate its size.
// Then, find the middle index using size/2.
// Traverse again up to the middle index and return that node.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 5
// Output: 3

class Middle{
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
    public void mid(){
        int size=0;
        Node temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(size==0){
            System.out.println("Null");
        }
        int mid=size/2;
        temp=head;
        for(int i=0;i<mid;i++){
            temp=temp.next;
        }
        System.out.print(temp.val);
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
public class MiddleNode {
    public static void main(String[] args) {
        Middle list=new Middle();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.mid();
    }
}

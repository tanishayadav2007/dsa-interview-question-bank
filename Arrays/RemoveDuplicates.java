// Problem: Remove Duplicates from Sorted List
// Company: Amazon

// Case Study:
// An e-commerce platform stores product IDs in sorted order.
// Due to system errors, duplicate entries may appear.
// To maintain data integrity, duplicates need to be removed.

// Problem Statement:
// Given a sorted linked list, remove duplicate nodes such that each element appears only once.

// Approach:
// Traverse the linked list using a pointer.
// If the current node value is equal to the next node value,
// skip the next node by updating the pointer (temp.next = temp.next.next).
// Otherwise, move to the next node.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 2 -> 2 -> 2 -> 2
// Output: 2


class Duplicate{
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
    public void remove(){
        Node temp=head;
        while(temp!=null&& temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("End");
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
public class RemoveDuplicates {
    public static void main(String[] args) {
        Duplicate list=new Duplicate();
        list.insert(2);
        list.insert(2);
        list.insert(2);
        list.insert(2);
        //list.insert(2);

        list.display();

        list.remove();

        list.display();

    }
}

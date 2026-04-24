// Problem: Swap Adjacent Nodes in Linked List
// Company: IBM

// Problem Statement:
// Given a singly linked list, swap every two adjacent nodes and return its head.
// You must solve the problem without modifying the values in the list nodes,
// only nodes themselves may be changed.

// Approach:
// Use reversal in groups of size 2.
// Traverse the list and reverse every pair of nodes.
// Use recursion to process the remaining list.
// Steps:
// 1. Reverse first two nodes using standard reversal logic.
// 2. Recursively call the function for the remaining list.
// 3. Connect the swapped pair with the result of recursive call.

// Time Complexity: O(n)
// Space Complexity: O(n) (due to recursion stack)

// Example:
// Input: 1 -> 2 -> 3 -> 4
// Output: 2 -> 1 -> 4 -> 3


class Swap{
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
    public Node swapadj(Node head){
        Node curr=head;
        Node prev=null;
        Node next_node=null;
        int count=0;
        while(curr!=null && count<2){
            next_node=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next_node;
            count++;
        }
        if(next_node!=null){
            head.next=swapadj(next_node);
        }
        return prev;
    }
}
public class SwapAdjacentNodes {
    public static void main(String[] args) {
        Swap list=new Swap();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();

        list.head=list.swapadj(list.head);
        list.display();
    }
}

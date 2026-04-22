// Problem: Count Nodes in a Linked List
// Company: Tata Consultancy Services (TCS)

// Problem Statement:
// Given a singly linked list, count the total number of nodes present in the list.
// If the list is empty (NULL), return 0.

// Approach:
// Traverse the linked list from head to end.
// Increment a counter for each node encountered.
// Return the final count.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4
// Output: 4

// Input: NULL
// Output: 0

class Count{
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
    public int count(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
}

public class CountNode {
    public static void main(String[] args) {
        Count list = new Count();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();
        System.out.print(list.count());
    }
}

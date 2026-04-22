// Problem: Reverse Nodes in Groups of K
// Company: Amazon

// Problem Statement:
// Given a singly linked list, reverse nodes in groups of size k.
// If the number of nodes is not a multiple of k,
// the remaining nodes should remain unchanged.

// Explanation:
// Each block of k nodes is reversed independently,
// without affecting the order of other groups.

// Approach:
// Reverse the first k nodes using three pointers (prev, curr, next).
// After reversing the first group, recursively process the remaining list.
// Connect the last node of the reversed group to the head of the next reversed group.

// Time Complexity: O(n)
// Space Complexity: O(n/k)  // due to recursion stack

// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2
// Output: 2 -> 1 -> 4 -> 3 -> 5


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

// Problem: Delete Node Without Head Pointer
// Company: IBM

// Problem Statement:
// Given only a pointer to a node (not the head), delete that node from the linked list.

// Approach:
// Since we don't have access to the previous node, we cannot directly remove the given node.
// Instead, copy the value of the next node into the current node,
// and then delete the next node by updating the pointer.

// Time Complexity: O(1)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3 -> 4 (delete node 3)
// Output: 1 -> 2 -> 4

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
    public void remove(Node node) {
        if (node == null || node.next == null) {
            System.out.println("Cannot delete this node");
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
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
public class DeleteNode{
    public static void main(String[] args) {
        Delete list=new Delete();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();

        Delete.Node temp = list.head;
        while (temp != null && temp.val != 3) {
            temp = temp.next;
        }
        list.remove(temp);
        list.display();

    }
}
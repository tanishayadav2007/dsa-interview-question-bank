// Problem: Palindrome Linked List
// Company: IBM

// Problem Statement:
// Given a singly linked list, determine whether it is a palindrome.
// A linked list is a palindrome if it reads the same forward and backward.

// Rules:
// - If the list reads the same from both directions → return true
// - Otherwise → return false

// Approach:
// First, traverse the linked list to calculate its size.
// Then, reach the middle of the list using size/2.
// If the size is odd, skip the middle element.
// Reverse the second half of the linked list.
// Finally, compare the first half with the reversed second half.

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input:  1 -> 2 -> 2 -> 1
// Output: true

// Input:  1 -> 2 -> 3
// Output: false


class PalinLL{
    Node head;
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    public boolean isPalindrome() {
        if(head==null||head.next==null){
            return true;
        }
        int size=0;
        Node temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int mid=size/2;
        Node secondhalf=head;
        for(int i=0;i<mid;i++){
            secondhalf=secondhalf.next;
        }
        if (size% 2==1){
            secondhalf = secondhalf.next;
        }

        secondhalf = reverse(secondhalf);

        Node firsthalf=head;
        while (secondhalf != null) {
            if (firsthalf.val != secondhalf.val) {
                return false;
            }
            firsthalf = firsthalf.next;
            secondhalf = secondhalf.next;
        }
        return true;
    }
    private Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("End");
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

}

public class Palindrome {
    public static void main(String[] args) {
        PalinLL list=new PalinLL();
        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(1);
        list.display();
        System.out.println(list.isPalindrome());
    }
}

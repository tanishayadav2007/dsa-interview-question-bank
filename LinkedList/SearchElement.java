// Problem: Search an Element in a Linked List
// Company: Capgemini

// Problem Statement:
// Given a singly linked list, search for a given value (key).
// Return "Found" if the element exists, otherwise return "Not Found".

// Approach:
// Traverse the linked list from head to end.
// Compare each node’s value with the target value.
// If a match is found, return "Found".
// If traversal completes without a match, return "Not Found".

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: 1 -> 2 -> 3, key = 3
// Output: Found

// Input: 1 -> 2 -> 3, key = 5
// Output: Not Found

class Search{
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
    public void searchElement(int target){
        if(head==null){
            System.out.println("Not Fountd");
            return;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.val==target){
                System.out.println("Found");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Not Found");
    }
}

public class SearchElement {
    public static void main(String[] args) {
        Search list=new Search();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();

        list.searchElement(3);
        list.searchElement(5);
    }
}


//company:Fidelity Investments

//Problem Statement:Given a singly linked list, return the Nth node from the end.

//Approach (Two Pass Method)
//Traverse the list to count total nodes.
//Calculate position from start → count - n
//Traverse again to that position.
//Remove and return the node value.

//Example
//Input:  1 → 2 → 3 → 4 → 5, n = 2  
//Output: 4

//Time Complexity: O(n) (two traversals)
//Space Complexity: O(1)

class Remove{
    Node head;
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
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
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public int removek(int k){
        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        temp=head;
        if(k==count){
        int val = head.val;
        head = head.next;
        return val;
    }
        for(int i=0;i<count-k-1;i++){
            temp=temp.next;
        }
        int val=temp.next.val;
        temp.next=temp.next.next;
        return val;
    }
}
public class RemoveFromLast{
    public static void main(String[] args) {
        Remove list =new Remove();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();
        System.out.println(list.removek(5));
        

    }
}
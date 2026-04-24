class Remove {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void remove(int val) {
        if (head == null) {
            System.out.println("Can't Remove");
            return;
        }

        // Handle head nodes
        while (head != null && head.val == val) {
            head = head.next;
        }

        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next; // delete
            } else {
                temp = temp.next; // move forward only if no deletion
            }
        }
    }
}

public class RemoveElementValue {
    public static void main(String[] args) {
        Remove list = new Remove();

        list.insert(1);
        list.insert(2);
        list.insert(6);
        list.insert(3);
        list.insert(6);
        list.display();

        list.remove(6);
        list.display();
    }
}
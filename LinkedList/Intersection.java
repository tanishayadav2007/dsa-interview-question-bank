// Problem: Intersection of Two Linked Lists
// Company: Amazon

// Problem Statement:
// Given two singly linked lists, find the node at which they intersect.
// If the two linked lists have no intersection, return NULL.
// Intersection means both lists share the same node (by reference, not value).

// Approach (Two Pointer Technique):
// 1. Initialize two pointers, p1 and p2, at heads of both lists.
// 2. Traverse both lists:
//    - When p1 reaches end, move it to head of second list.
//    - When p2 reaches end, move it to head of first list.
// 3. Continue until p1 == p2.
// 4. The meeting point is the intersection node (or NULL if no intersection).

// Time Complexity: O(n + m)
// Space Complexity: O(1)

// Example:
// Input:
// List A: 1 -> 2 -> 3 -> 4
// List B: 5 -> 3 -> 4   (3 is shared node)

// Output: 3

// Input:
// List A: 1 -> 2 -> 3
// List B: 4 -> 5 -> 6

// Output: NULL


class Intersection {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        // Traverse both lists
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1; // intersection node or null
    }

    public static void main(String[] args) {

        // Creating shared part: 3 -> 4
        ListNode common = new ListNode(3);
        common.next = new ListNode(4);

        // List A: 1 -> 2 -> 3 -> 4
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = common;

        // List B: 5 -> 3 -> 4
        ListNode headB = new ListNode(5);
        headB.next = common;

        ListNode result = getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
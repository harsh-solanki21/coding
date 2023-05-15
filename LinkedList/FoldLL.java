package LinkedList;

public class FoldLL {

    // https://leetcode.com/problems/reorder-list/
//    You are given the head of a singly linked-list. The list can be represented as:
//    L0 → L1 → … → Ln - 1 → Ln
//    Reorder the list to be on the following form:
//    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …


    // Fold a linked list means,
//     Question: 1 -> 2 -> 3 -> 4 -> 5
//     Solution: 1 -> 5 -> 2 -> 4 -> 3

    static Node head;
    static Node tail;
    static int size = 0;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            tail = node;
        }
        size++;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // APPROACH 1
    // Recursive Approach
    Node left;

    void fold() {
        left = head;
        foldHelper(head, 0);
    }

    private void foldHelper(Node right, int floor) {
        if (right == null)
            return;
        foldHelper(right.next, floor + 1);

        if (floor > size / 2) {
            Node temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        } else if (floor == size / 2) {
            tail = right;
            tail.next = null;
        }
    }


    // APPROACH 2
//    1. Find middle of LinkedList
//    2. reverse it
//    3. Compare and Swap it

    // Example
//    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7   (Question)
//    1 -> 2 -> 3 -> 4 -> 7 -> 6 -> 5   (find middle and Reverse the right part)
//    1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4   (first pointer on start and second pointer on mid+1) (Answer)

    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = middleNode(head);
        Node headFirst = head;
        Node headSecond = reverseList(mid);

        while (headFirst != null && headSecond != null) {
            Node temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }

        if (headFirst != null) {
            headFirst.next = null;
        }

    }

    private Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }


    public static void main(String[] args) {
        FoldLL ll = new FoldLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.display();
//        ll.fold();
        ll.reorderList(head);
        ll.display();
    }

}

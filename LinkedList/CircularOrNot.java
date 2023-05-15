package LinkedList;

public class CircularOrNot {

    static Node head1, head2;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }


    // find whether the linked list is circular or not
    // TC - O(n), SC - O(1)
    boolean isCircular(Node head) {
        if (head == null) {
            return false;
        }

        Node temp = head.next;
        while (temp != null && temp != head) {
            temp = temp.next;
        }

        return temp == head;
    }


    public static void main(String[] args) {
        CircularOrNot list = new CircularOrNot();

        // Circular
        head1 = new Node(7);
        head1.next = new Node(5);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);
        head1.next.next.next.next.next = head1;

        // Not Circular
        head2 = new Node(7);
        head2.next = new Node(5);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(6);

        System.out.println(list.isCircular(head1));
        System.out.println(list.isCircular(head2));
    }

}

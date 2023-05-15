package LinkedList;

public class PartitionList {

    static Node head;

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    static void display(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }


    // Given the head of a linked list and a value x,
    // partition it such that all nodes less than x come before nodes greater than or equal to x.
    //You should preserve the original relative order of the nodes in each of the two partitions.

    static Node partition(Node head, int x) {
        Node left = new Node(0);
        Node right = new Node(0);

        Node leftTail = left;
        Node rightTail = right;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }

        leftTail.next = right.next;
        rightTail.next = null;

        return left.next;
    }


    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);

        int x = 3;

        display(head);
        Node node = partition(head, x);
        display(node);
    }

}

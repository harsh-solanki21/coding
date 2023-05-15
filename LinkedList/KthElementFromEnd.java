package LinkedList;

public class KthElementFromEnd {

    static Node head;
    static Node tail;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Solve using iteration, in single traversal and don't use size property directly or indirectly
    // Slow and Fast pointer
    static int kthFromLast(int k) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println(kthFromLast(2));
    }

}

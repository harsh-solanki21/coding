package LinkedList;

public class SwapKthNodes {

    // Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void display(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }


    // Swap Kth node
    static Node swapNodes(Node head, int k) {
        Node start = head;
        Node end = head;
        Node fast = head;

        for (int i = 1; i < k; i++) {
            start = start.next;
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            end = end.next;
        }

        int temp = start.data;
        start.data = end.data;
        end.data = temp;

        return head;
    }


    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        display(head);
        Node node = swapNodes(head, k);
        display(node);
    }

}

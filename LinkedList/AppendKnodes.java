package LinkedList;

public class AppendKnodes {

    // Append last K nodes to start of linked list

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
        System.out.print("null\n");
    }


    // count of nodes
    static int countNodes(Node node) {
        int count = 1;
        Node temp = node;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    static Node appendKNodesToStart(Node head, int k) {
        int count = countNodes(head);

        Node temp = head;
        for (int i = 0; i < count - k - 1; i++) {
            temp = temp.next;
        }

        Node newTail = temp;
        Node newHead = temp.next;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;
        newTail.next = null;
        head = newHead;

        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        display(head);

        int m = 3;
        Node ans = appendKNodesToStart(head, m);
        display(ans);
    }

}

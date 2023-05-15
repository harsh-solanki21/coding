package LinkedList;

public class SwapNodesInPair {

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


    // Recursive
    static Node swapPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head.next;
        Node pre = head;
        int temp = pre.data;
        pre.data = current.data;
        current.data = temp;
        swapPairs(current.next);
        return head;
    }


    // Iterative
    static Node swapPairs2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = head, foll = head.next;
        while (foll != null) {
            int temp = pre.data;
            pre.data = foll.data;
            foll.data = temp;
            if (foll.next != null) {
                foll = foll.next.next;
                pre = pre.next.next;
            }
            else {
                break;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        display(head);

//        Node node = swapPairs(head);
        Node node = swapPairs2(head);

        display(node);
    }

}

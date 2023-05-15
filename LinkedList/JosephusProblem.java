package LinkedList;

public class JosephusProblem {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static void createCircularLL(int n) {
        Node temp = head;
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            if (temp == null) {
                temp = node;
                head = temp;
            } else {
                temp.next = node;
                temp = temp.next;
            }

        }

        temp.next = head;
    }

    static void display() {
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("null");
    }

    static int josephusProblem(int n, int k) {
        Node node = head;
        while (n != 1) {
            for (int i = 0; i < k - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            n--;
        }

        return node.data;
    }

    public static void main(String[] args) {
        int n = 7, k = 4;
        createCircularLL(n);
        display();

        System.out.println(josephusProblem(n, k));
    }

}

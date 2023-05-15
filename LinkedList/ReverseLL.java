package LinkedList;

public class ReverseLL {

    static Node head, tail;
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
        }
        else {
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

    /*  ITERATIVE  */
    Node reverseIterative(Node head) {
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

    /*  Two Pointer  */
    void reverseTwoPointer() {
        int i = 0;
        int j = 0;  // if tail is not there
        Node node = head;
        while (node.next != null) {
            node = node.next;
            j++;
        }
        while (i < j) {
            Node left = getNodeAt(i);
            Node right = getNodeAt(j);
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            i++;
            j--;
        }
    }

    private Node getNodeAt(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /*  RECURSIVE  */
    void reverseRecursive(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverseRecursive(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    /*  Display LinkedList in reverse without actually reversing it  */
    void displayReverse(Node node) {
        if (node == null)
            return;
        displayReverse(node.next);
        System.out.print(node.data + " ");
    }

    /*  Reverse LinkedList by swapping Data  */
    Node left;
    void reverseDataRecursive() {
        left = head;
        reverseDataRecursiveHelper(head, 0);
    }

    void reverseDataRecursiveHelper(Node right, int floor) {
        if (right == null)
            return;
        reverseDataRecursiveHelper(right.next, floor + 1);
        if (floor >= size / 2) {
            int temp = right.data;
            right.data = left.data;
            left.data = temp;
            left = left.next;
        }
    }

    public static void main(String[] args) {
        ReverseLL list = new ReverseLL();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);

        System.out.println("Given Linked list");
        list.display();
//        head = list.reverseIterative(head);
        list.reverseRecursive(head);
//        list.reverseTwoPointer();
//        System.out.println("Reversed linked list ");
        list.display();
//        list.displayReverse(head);
//        list.reverseDataRecursive();
//        list.display();
    }

}

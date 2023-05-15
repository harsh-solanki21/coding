package LinkedList;

public class SegregateEvenOdd {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            next = null;
            this.data = data;
        }
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if (head == null)
            head = node;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // TC - O(n)
    static void segregateEvenOdd() {
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node currentNode = head;

        while (currentNode != null) {
            int element = currentNode.data;

            if (element % 2 == 0) {
                if (evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                }
                else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }

            } else {
                if (oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                }
                else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            currentNode = currentNode.next;
        }

        if (oddStart == null || evenStart == null)
            return;

        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
    }

    public static void main(String[] args) {
        SegregateEvenOdd ll = new SegregateEvenOdd();
        ll.addLast(2);
        ll.addLast(9);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(1);
        ll.addLast(6);
        ll.addLast(5);
        ll.addLast(4);

        ll.display();
        segregateEvenOdd();
        ll.display();

    }

}

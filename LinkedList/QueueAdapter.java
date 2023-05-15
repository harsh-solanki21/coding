package LinkedList;

public class QueueAdapter {

    Node head;

    class Node {
        Node next;
        int data;

        Node(int data) {
            next = null;
            this.data = data;
        }
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        if (head == null)
            return 0;
        int len = 1;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    void add(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    void remove() {
        if(size() == 0)
            System.out.println("Queue Underflow");
        else
            head = head.next;
    }

    int peek() {
        if(size() == 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        else
            return head.data;
    }

    void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        QueueAdapter ql = new QueueAdapter();
        ql.add(10);
        ql.add(20);
        ql.add(30);
        ql.add(40);
        ql.display();
        System.out.println(ql.peek());
        ql.remove();
        ql.remove();
        System.out.println(ql.peek());
        System.out.println(ql.size());
        System.out.println(ql.isEmpty());
    }

}

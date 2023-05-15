package LinkedList;

public class StackAdapter {

    Node head;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            next = null;
            this.data = data;
        }
    }

    int size() {
        int len = 1;
        if (head == null)
            return 0;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    void pop() {
        head = head.next;
    }

    int peek() {
        if (head == null)
            return -1;
        else
            return head.data;
    }

    boolean isEmpty() {
        return head == null;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        StackAdapter sl = new StackAdapter();
        sl.push(40);
        sl.push(30);
        sl.push(20);
        sl.push(10);
        sl.display();
        System.out.println(sl.peek());
        sl.pop();
        sl.pop();
        System.out.println(sl.peek());
        System.out.println(sl.size());
        System.out.println(sl.isEmpty());
    }

}

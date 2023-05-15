package LinkedList;

import java.util.HashMap;

public class RemoveDuplicatesInSortedLL {

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

    // TC - O(n), SC - O(1)
    static void removeDuplicates1() {
        Node curr = head;
        while (curr != null) {
            Node temp = curr;
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }

    // TC - O(n), SC - O(1)
    static void removeDuplicates2() {
        Node temp = head, prev = head;
        while (temp != null) {
            if (temp.data != prev.data) {
                prev.next = temp;
                prev = temp;
            }
            temp = temp.next;
        }
        if (prev != temp)
            prev.next = null;
    }

    // TC - O(n), SC - O(n)
    static void removeDuplicates3(Node head) {
        HashMap<Integer, Boolean> track = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            if (!track.containsKey(temp.data)) {
                System.out.print(temp.data + " -> ");
            }
            track.put(temp.data, true);
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedLL ll = new RemoveDuplicatesInSortedLL();
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(5);
        ll.addLast(5);
        ll.addLast(5);

        ll.display();
//        removeDuplicates1();
//        removeDuplicates2();
//        ll.display();
        removeDuplicates3(head);

    }

}

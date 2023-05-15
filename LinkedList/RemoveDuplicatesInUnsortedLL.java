package LinkedList;

import java.util.HashSet;

public class RemoveDuplicatesInUnsortedLL {

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

    // TC - O(n^2)
    static void removeDuplicates1() {
        Node ptr1 = head, ptr2 = null;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.data == ptr2.next.data)
                    ptr2.next = ptr2.next.next;
                else
                    ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }

    static void removeDuplicates2(Node head) {
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            int curval = current.data;
            if (hs.contains(curval)) {
                prev.next = current.next;
            }
            else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesInUnsortedLL ll = new RemoveDuplicatesInUnsortedLL();
        ll.addLast(10);
        ll.addLast(12);
        ll.addLast(11);
        ll.addLast(11);
        ll.addLast(12);
        ll.addLast(11);
        ll.addLast(10);
        ll.addLast(15);
        ll.addLast(18);
        ll.addLast(15);

        ll.display();
//        removeDuplicates1();
        removeDuplicates2(head);
        ll.display();

    }

}

package LinkedList;

import java.util.HashMap;

public class CopyListRandomPointer {

    static Node head;

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static void display(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }


    // Clone Linked List
    // Copy Linked List with Random Pointer

    // APPROACH 1
    // TC - O(n), SC - O(n)
    static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node originalHead = head;

        // Creating hashmap with original nodes as keys, and copy nodes as values
        while (head != null) {
            map.put(head, new Node(head.val));
            head = head.next;
        }
        head = originalHead;

        while (head != null) {
            // Setting next and random value to all copies
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }

        // returning the first value of hashmap (key is initial head node)
        return map.get(originalHead);
    }


    // APPROACH 2
    // TC - O(n), SC - O(1)
    static Node clone(Node head) {
        Node node = head, temp = null;
        while (node != null) {
            temp = node.next;
            node.next = new Node(node.val);
            node.next.next = temp;
            node = temp;
        }
        node = head;

        while (node != null) {
            if (node.next != null) {
                node.next.random = (node.random != null) ? node.random.next : node.random;
            }
            node = node.next.next;
        }

        Node original = head, copy = head.next;
        temp = copy;

        while (original != null) {
            original.next = original.next.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }

        return temp;
    }


    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Approach 1
//        display(head);
//        Node node = copyRandomList(head);
//        display(node);

        // Approach 2
        display(head);
        Node node = clone(head);
        display(node);
    }

}

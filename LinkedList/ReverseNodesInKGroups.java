package LinkedList;

public class ReverseNodesInKGroups {

    static Node head;
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
        if (head == null)
            head = node;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    void display(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // Recursive Approach
    // TC - O(n), SC - O(n)
    // It will also reverse a group which doesn't add up to size k
    public Node reverseInGroups(Node head, int k) {
        if (head == null) {
            return null;
        }

        Node current = head;
        Node prev = null;
        int count = 0;

        while (current != null && count < k) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        head.next = reverseInGroups(current, k);
        return prev;
    }


    // Iterative Approach
    // TC - O(n), SC - O(1)
    // It will also reverse a group which doesn't add up to size k
    public Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null)
            return head;

        Node current = head;
        Node prev = null;
        while (true) {
            Node last = prev;
            Node newEnd = current;

            // reverse between left and right
            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null)
                last.next = prev;
            else
                head = prev;

            newEnd.next = current;
            if (current == null)
                break;

            prev = newEnd;

        }

        return head;
    }


    // https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
    // Iterative Approach
    // TC - O(n), SC - O(1)
    // It will also reverse a group which doesn't add up to size k
    public Node reverseAlternateKGroups(Node head, int k) {
        if (k <= 1 || head == null)
            return head;

        Node current = head;
        Node prev = null;
        while (current != null) {
            Node last = prev;
            Node newEnd = current;

            // reverse between left and right
            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null)
                last.next = prev;
            else
                head = prev;

            newEnd.next = current;
            // skip the k nodes
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }

        }

        return head;
    }


    // https://leetcode.com/problems/reverse-nodes-in-k-group/
    // https://takeuforward.org/data-structure/reverse-linked-list-in-groups-of-size-k/
    // Iterative Approach
    // TC - O(n), SC - O(1)
    // It won't reverse a group which doesn't add up to size k
    Node reverseKNodes(Node head, int k) {
        if (head == null || head.next == null)
            return head;

        int length = findLength(head);

        Node dummyHead = new Node(0);
        dummyHead.next = head;

        Node pre = dummyHead;
        Node cur;
        Node nex;

        while (length >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            length -= k;
        }

        return dummyHead.next;
    }

    int findLength(Node node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }


    public static void main(String[] args) {
        ReverseNodesInKGroups ll = new ReverseNodesInKGroups();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.addLast(60);
        ll.addLast(70);
        ll.addLast(80);
        ll.display(head);
        int k = 3;

        Node recursive = ll.reverseInGroups(head, k);
        ll.display(recursive);

//        Node res = ll.reverseKGroup(head, k);
//        ll.display(res);

//        Node alternate = ll.reverseAlternateKGroups(head, k);
//        ll.display(alternate);

//        Node ans = ll.reverseKNodes(head, k);
//        ll.display(ans);

    }

}

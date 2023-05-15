package LinkedList;

public class Palindrome {

    Node head;
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

    public void display() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }

    // Iterative
    boolean isPalindrome() {
        if (head == null && head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;
        while (slow != null) {
            if (fast.data != slow.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null, later = null;
        Node current = head;
        while (current != null) {
            later = current.next;
            current.next = prev;
            prev = current;
            current = later;
        }
        head = prev;
        return head;
    }

    // Recursive => TC - O(n)
    Node left;
    boolean isPalindromeRecursive() {
        left = head;
        return isPalindromeRecursiveHelper(head);
    }

    boolean isPalindromeRecursiveHelper(Node right) {
        if (right == null)
            return true;
        boolean ans = isPalindromeRecursiveHelper(right.next);
        if (!ans)
            return false;
        else if (left.data != right.data)
            return false;
        else {
            left = left.next;
            return true;
        }
    }

    public static void main(String[] args) {
        Palindrome list = new Palindrome();
        list.addLast(3);
        list.addLast(6);
        list.addLast(9);
        list.addLast(6);
        list.addLast(3);

        list.display();
//        System.out.println(list.isPalindrome());
        System.out.println(list.isPalindromeRecursive());

    }

}

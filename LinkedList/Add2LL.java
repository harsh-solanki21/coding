package LinkedList;

public class Add2LL {

    static Node head1, head2, head3, tail3;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void insertLast(int data) {
        Node node = new Node(data);
        if (head3 == null) {
            head3 = node;
            tail3 = node;
            return;
        }
        tail3.next = node;
        tail3 = node;
    }

    void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Reverse
    Node reverse(Node head) {
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

    // add two lists
    // TC - O(n + m), SC - O(Max(n, m))
    Node addTwoLists(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
        Node ans = add(first, second);
        ans = reverse(ans);
        return ans;
    }

    Node add(Node first, Node second) {

        int carry = 0;
        while (first != null || second != null || carry != 0) {
            int val1 = 0, val2 = 0;
            if (first != null) {
                val1 = first.data;
            }
            if (second != null) {
                val2 = second.data;
            }

            int sum = carry + val1 + val2;
            int digit = sum % 10;
            insertLast(digit);
            carry = sum / 10;

            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        return head3;

    }


    // Approach 2
    // https://leetcode.com/problems/add-two-numbers/
    static Node addTwoNumbers(Node l1, Node l2) {
        Node head = new Node(-1);
        Node temp = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return head.next;
    }


    public static void main(String[] args) {
        Add2LL list = new Add2LL();

        // first list
        head1 = new Node(7);
        head1.next = new Node(5);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);
        list.display(head1);

        // second list
        head2 = new Node(8);
        head2.next = new Node(4);
        list.display(head2);

        // result
        Node ans = list.addTwoLists(head1, head2);
        list.display(ans);

        // Approach 2
        Node res = addTwoNumbers(head1, head2);
        list.display(res);
    }

}

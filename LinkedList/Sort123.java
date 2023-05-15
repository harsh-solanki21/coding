package LinkedList;

public class Sort123 {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void display(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // Approach 1 (data replacement)
    void sort123Approach1() {

        Node node = head;
        int zero = 0, one = 0, two = 0;
        while (node != null) {
            if (node.data == 0)
                zero++;
            else if (node.data == 1)
                one++;
            else if (node.data == 2)
                two++;
            node = node.next;
        }

        node = head;
        while (node != null) {
            if (zero != 0) {
                node.data = 0;
                zero--;
            } else if (one != 0) {
                node.data = 1;
                one--;
            } else if (two != 0) {
                node.data = 2;
                two--;
            }
            node = node.next;
        }

    }

    // Approach 2 (change node links)
    Node sort123Approach2() {

        if (head == null || head.next == null) {
            return head;
        }

        // maintain three dummy nodes
        Node first = new Node(-1), second = new Node(-1), third = new Node(-1);

        // maintain three references
        Node zero = first, one = second, two = third;

        // traverse the list
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // combine lists containing 0's, 1's, and 2's
        zero.next = (second.next != null) ? (second.next) : (third.next);
        one.next = third.next;
        two.next = null;

        // change head
        return first.next;

    }

    void insertTail(Node tail, Node current) {
        tail.next = current;
        tail = current;
    }


    // Approach 3 (Two Pointers)
    void sort123Approach3() {
        int start = 0, mid = 0;
        int end = 0;
        Node node = head;
        while (node.next != null) {
            node = node.next;
            end++;
        }

        while (mid <= end) {
            Node left = getNodeAt(start);
            Node middle = getNodeAt(mid);
            Node right = getNodeAt(end);
            switch (getNodeAt(mid).data) {
                case 0:
                    int temp = left.data;
                    left.data = middle.data;
                    middle.data = temp;
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = middle.data;
                    middle.data = right.data;
                    right.data = temp;
                    end--;
                    break;
            }
        }

    }

    private Node getNodeAt(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        Sort123 list = new Sort123();

        head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        list.display(head);

//        list.sort123Approach1();
//        list.display(head);

//        Node ans = list.sort123Approach2();
//        list.display(ans);

        list.sort123Approach3();
        list.display(head);

    }

}

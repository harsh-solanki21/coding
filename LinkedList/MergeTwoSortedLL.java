package LinkedList;

public class MergeTwoSortedLL {

    Node head;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            next = null;
            this.data = data;
        }
    }

    void addLast(int data) {
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

    static Node mergeTwoSortedLists(Node l1, Node l2) {
        MergeTwoSortedLL ans = new MergeTwoSortedLL();
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                ans.addLast(l1.data);
                l1 = l1.next;
            } else {
                ans.addLast(l2.data);
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            ans.addLast(l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            ans.addLast(l2.data);
            l2 = l2.next;
        }
        return ans.head;
    }

    void display(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeTwoSortedLL l1 = new MergeTwoSortedLL();
        l1.addLast(10);
        l1.addLast(20);
        l1.addLast(30);
        l1.addLast(40);
        l1.addLast(50);
        l1.display(l1.head);

        MergeTwoSortedLL l2 = new MergeTwoSortedLL();
        l2.addLast(7);
        l2.addLast(9);
        l2.addLast(12);
        l2.addLast(15);
        l2.addLast(37);
        l2.addLast(43);
        l2.addLast(44);
        l2.addLast(45);
        l2.addLast(52);
        l2.addLast(56);
        l2.display(l2.head);

        Node ans = mergeTwoSortedLists(l1.head, l2.head);
        while (ans != null) {
            System.out.print(ans.data + " -> ");
            ans = ans.next;
        }
        System.out.println("null");
    }

}

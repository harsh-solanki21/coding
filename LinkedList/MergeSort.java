package LinkedList;

public class MergeSort {

    // Merge Sort is preferred for Linked Lists because:
    // 1. If we have to access an ith index in a linked list using quicksort, we will have to travel every node
    // from the head node to the ith node as we do not have a contiguous memory block.
    // As a result, the cost of quicksort rises. Whereas merge sort sequentially accesses data,
    // therefore the need for random access is low.

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node sortedMerge(Node a, Node b) {
        Node result;
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node middle = getMiddle(node);
        Node nextOfMid = middle.next;

        middle.next = null;
        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMid);
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    public static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    void display(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        MergeSort ms = new MergeSort();
        ms.push(15);
        ms.push(10);
        ms.push(5);
        ms.push(20);
        ms.push(3);
        ms.push(2);
        ms.display(ms.head);

        ms.head = ms.mergeSort(ms.head);
        ms.display(ms.head);
    }

}

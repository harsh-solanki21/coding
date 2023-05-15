package LinkedList;

public class InsertRecursive {

    Node head;
    int size = 0;
    class Node {
        int val;
        Node next;
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // insert using recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    // Print
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        InsertRecursive list = new InsertRecursive();
        list.insertRec(1, 0);
        list.insertRec(2, 1);
        list.insertRec(4, 2);
        list.insertRec(5, 3);
        list.display();
        list.insertRec(3, 2);
        list.display();
    }

}

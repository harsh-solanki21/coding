package LinkedList;

class LinkedList {

    Node head;

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    /*  INSERTION  */
    public void insertAtHead(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    public void insertAtTail(int data) {
        Node n = new Node(data);
        if(head == null) {
            head = n;
            return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = n;
    }

    public void insertAtPosition(int data, int position) {
        Node temp = head;
        for(int i=0; i<position-1; i++)
            temp = temp.next;
        Node after = temp.next;
        Node n = new Node(data);
        n.next = after;
        temp.next = n;
    }

    /*  DELETION  */
    public void removeAtHead() {
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    public void removetAtTail() {
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void removeAtPosition(int position) {
        if(head == null)
            return;
        Node temp = head;
        if(position == 0) {
            head = temp.next;
            return;
        }
        for(int i=0; temp != null && i < position-1; i++) {
            temp = temp.next;
        }
        if(temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next;
    }

    /*  SEARCH  */
    public int searchNode(int data) {
        Node temp = head;
        int index = 0;
        while(temp.data != data) {
            temp = temp.next;
            index++;
        }
        return index;
    }

    /*  PRINT  */
    public void display() {
        Node n = head;
        while(n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(5);
        list.insertAtTail(7);
        list.insertAtTail(1);
        list.insertAtPosition(2,2);
        list.display();
        System.out.println("Index : " + list.searchNode(1));
        System.out.println("After Deletion");
        list.removeAtHead();
        list.removetAtTail();
        list.removeAtPosition(1);
        list.display();
    }

}

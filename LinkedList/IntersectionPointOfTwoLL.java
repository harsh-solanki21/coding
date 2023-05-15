package LinkedList;

public class IntersectionPointOfTwoLL {

    // Here, the intersection point is e.
//      a
//       \
//         b
//          \
//            c         h
//             \       /
//              d     i
//               \   /
//                 e
//                 |
//                 f
//                 |
//                 g

    static Node head1, head2;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // function to get the intersection point of two linked lists head1 and head2
    static int getNode() {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int diff;

        if (c1 > c2) {
            diff = c1 - c2;
            return getIntesectionNode(diff, head1, head2);
        }
        else {
            diff = c2 - c1;
            return getIntesectionNode(diff, head2, head1);
        }
    }

    // Takes head pointer of the linked list and returns the count of nodes in the list
    private static int getCount(Node node) {
        Node current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // function to get the intersection point of two linked lists head1 and head2 where head1 has d more nodes than head2
    private static int getIntesectionNode(int diff, Node node1, Node node2) {
        Node curr1 = node1;
        Node curr2 = node2;

        for (int i = 0; i < diff; i++) {
            if (curr1 == null) {
                return -1;
            }
            curr1 = curr1.next;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1.data == curr2.data) {
                return curr1.data;
            }
            curr1 = curr2;
            curr2 = curr2.next;
        }

        return -1;
    }

    public static void main(String[] args) {

        // first linked list
        head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);

        // second linked list
        head2 = new Node(9);
        head2.next = new Node(15);
        head2.next.next = new Node(30);

        System.out.println("Intersection Point is: " + getNode());
    }

}

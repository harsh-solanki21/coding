package LinkedList;

public class FlatteningLL {

//    Given a linked list where every node represents a linked list and contains two pointers of its type:
//    Pointer to next node in the main list (we call it ‘right’ pointer in the code below)
//    Pointer to a linked list where this node is headed (we call it the ‘down’ pointer in the code below).
//
//    All linked lists are sorted. See the following example
//
//       5 -> 10 -> 19 -> 28
//       |    |     |     |
//       V    V     V     V
//       7    20    22    35
//       |          |     |
//       V          V     V
//       8          50    40
//       |                |
//       V                V
//       30               45
//
//    Write a function flatten() to flatten the lists into a single linked list.
//    The flattened linked list should also be sorted.
//    For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.


    static Node head;

    static class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = down = null;
        }
    }

    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.down;
        }
        System.out.println("null");
    }

    static Node push(Node head, int data) {
        Node node = new Node(data);
        node.down = head;
        head = node;
        return head;
    }


    // flatten
    static Node flatten(Node root) {
        if (root == null || root.right == null) {
            return root;
        }

        // recur for list on right
        root.right = flatten(root.right);

        // now merge
        root = merge(root, root.right);

        // return the root, it will be in turn merged with its left
        return root;
    }

    private static Node merge(Node a, Node b) {
        // if first linked list is empty then second is the answer
        if (a == null) {
            return b;
        }

        // if second linked list is empty then first is the result
        if (b == null) {
            return a;
        }

        // compare the data members of the two linked lists and put the larger one in the result
        Node result;

        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        }
        else {
            result = b;
            result.down = merge(a, b.down);
        }

        result.right = null;
        return result;
    }


    public static void main(String[] args) {
        head = push(head, 30);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 5);

        head.right = push(head.right, 20);
        head.right = push(head.right, 10);

        head.right.right = push(head.right.right, 50);
        head.right.right = push(head.right.right, 22);
        head.right.right = push(head.right.right, 19);

        head.right.right.right = push(head.right.right.right, 45);
        head.right.right.right = push(head.right.right.right, 40);
        head.right.right.right = push(head.right.right.right, 35);
        head.right.right.right = push(head.right.right.right, 28);

        // flatten the list
        head = flatten(head);

        display();
    }

}

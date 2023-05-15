package Tree.BinarySearchTree;

public class PrintInRange {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    // Print all the nodes whose value is in between given range (inclusively - means including range values)
    // Print in Increasing Order
    static void printInRange(Node node, int lo, int hi) {
        if (node == null) {
            return;
        }

        if (lo < node.data && hi < node.data) {
            printInRange(node.left, lo, hi);
        } else if (lo > node.data && hi > node.data) {
            printInRange(node.right, lo, hi);
        } else {
            printInRange(node.left, lo, hi);
            System.out.print(node.data + " ");
            printInRange(node.right, lo, hi);
        }
    }


    public static void main(String[] args) {
        root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        root.right.right.left = new Node(80);
        root.right.right.left.left = new Node(78);
        root.right.right.left.right = new Node(82);

        printInRange(root, 27, 72);
    }

}

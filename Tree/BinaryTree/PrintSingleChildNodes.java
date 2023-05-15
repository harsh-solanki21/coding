package Tree.BinaryTree;

public class PrintSingleChildNodes {

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

    static void printSingleChildNodes(Node node, Node parent) {
        if (node == null) {
            return;
        }

        if (parent != null && parent.left == node && parent.right == null) {
            System.out.print(node.data + " ");
        } else if (parent != null && parent.left == null && parent.right == node) {
            System.out.print(node.data + " ");
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static void main(String[] args) {
        root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.left.right.left = new Node(30);
        root.right.left.left = new Node(60);

        printSingleChildNodes(root, null);
    }

}

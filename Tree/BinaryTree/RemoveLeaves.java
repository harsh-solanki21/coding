package Tree.BinaryTree;

public class RemoveLeaves {

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

    static void display(Node node) {
        if (node == null) {
            System.out.print(-1 + " ");
            return;
        }

        System.out.print(node.data + " ");
        display(node.left);
        display(node.right);
    }


    static Node removeLeaves(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);

        Node node = removeLeaves(root);
        display(node);
    }

}

package Tree.BinaryTree.MAANG_Ques;

public class FlattenBinaryTree {

    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Flatten Binary Tree to Linked List or Skewed Binary Tree
    static void flatten(Node root) {
        while (root != null) {
            if (root.left != null) {
                Node prev = root.left;
                // Find the rightmost node in left subtree
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    static void printPreorder(Node root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        flatten(root);
        printPreorder(root);
    }

}

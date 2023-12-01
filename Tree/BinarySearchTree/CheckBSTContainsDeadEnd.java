package Tree.BinarySearchTree;

public class CheckBSTContainsDeadEnd {

//    Given a Binary Search Tree that contains unique positive integer values greater than 0.
//    The task is to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false.
//    Here Dead End means a leaf node, at which no other node can be inserted.

    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    // Check whether BST contains Dead End
    static boolean isDeadEnd(Node root) {
        return helper(root, 1, Integer.MAX_VALUE);
    }

    private static boolean helper(Node root, int min, int max) {
        if (root == null) {
            return false;
        }
        if (min == max) {
            return true;
        }

        boolean left = helper(root.left, min, root.data - 1);
        boolean right = helper(root.right, root.data + 1, max);

        return left || right;
    }


    public static void main(String[] args) {
        root = new Node(8);
        root.left = new Node(7);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.right.left = new Node(9);
        root.right.right = new Node(13);

        System.out.println(isDeadEnd(root));
    }

}

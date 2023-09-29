package Tree.BinaryTree.MAANG_Ques;

public class SymmetricTree {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // Symmetric Tree
    static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.data != node2.data) {
            return false;
        }
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(6);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(5);

        System.out.println(isSymmetric(root));
    }

}

package Tree.BinarySearchTree;

public class KthSmallestElement {

    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    static int count = 0;

    static int kthSmallest(Node root, int k) {
        return inOrder(root, k).data;
    }

    private static Node inOrder(Node root, int k) {
        if (root == null) {
            return null;
        }

        Node left = inOrder(root.left, k);
        if (left != null) {
            return left;
        }

        count++;
        if (count == k) {
            return root;
        }
        return inOrder(root.right, k);
    }


    public static void main(String[] args) {
        root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        root.left.right.left = new Node(30);
        root.left.right.right = new Node(40);

        int k = 3;
        System.out.println(kthSmallest(root, k));
    }

}

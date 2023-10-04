package Tree.BinaryTree;

public class SizeSumMinMaxHeight {

    Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // TC - O(n)
    // Size of tree means total no. of nodes
    static int size(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = size(root.left);
        int rightNodes = size(root.right);
        return leftNodes + rightNodes + 1;
    }

    // TC - O(n)
    static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    // TC - O(n)
    static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int ans = node.data;
        int left = max(node.left);
        int right = max(node.right);
        return Math.max(left, Math.max(right, ans));
    }

    // TC - O(n)
    static int min(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int ans = node.data;
        int left = min(node.left);
        int right = min(node.right);
        return Math.min(left, Math.min(right, ans));
    }


    // Distance from root to the deepest leaf is the Height/depth of tree
    // TC - O(n)
    static int height(Node root) {
        if (root == null) {
            return 0;  // 0 for nodes, -1 for edges
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static void main(String[] args) {
        SizeSumMinMaxHeight tree = new SizeSumMinMaxHeight();
        tree.root = new Node(50);
        tree.root.left = new Node(25);
        tree.root.right = new Node(75);
        tree.root.left.left = new Node(12);
        tree.root.left.right = new Node(37);
        tree.root.left.right.left = new Node(30);
        tree.root.right.left = new Node(62);
        tree.root.right.right = new Node(87);
        tree.root.right.left.right = new Node(70);

        System.out.println(size(tree.root));
        System.out.println(sum(tree.root));
        System.out.println(min(tree.root));
        System.out.println(max(tree.root));
        System.out.println(height(tree.root));
    }

}

package Tree.BinaryTree;

public class BalancedBinaryTree {

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


    // Approach 1
    static boolean isBalanced = true;

    static int isBalanced1(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = isBalanced1(node.left);
        int rightHeight = isBalanced1(node.right);

        int gap = Math.abs(leftHeight - rightHeight);
        if (gap > 1) {
            isBalanced = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }


    // Approach 2
    static class Pair {
        int height;
        boolean isBalanced;
    }

    static Pair isBalanced2(Node node) {
        if (node == null) {
            Pair basePair = new Pair();
            basePair.height = 0;
            basePair.isBalanced = true;
            return basePair;
        }

        Pair leftPair = isBalanced2(node.left);
        Pair rightPair = isBalanced2(node.right);

        Pair pair = new Pair();
        pair.isBalanced = Math.abs(leftPair.height - rightPair.height) <= 1 && leftPair.isBalanced && rightPair.isBalanced;
        // to check node is balanced                    // to check whole left and right tree is balanced
        pair.height = Math.max(leftPair.height, rightPair.height) + 1;
        return pair;
    }


    public static void main(String[] args) {
        root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(12);
        root.left.right = new Node(17);
        root.right.left = new Node(14);
        root.right.right = new Node(9);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(18);
        root.right.left.right.right = new Node(20);

        isBalanced1(root);
        System.out.println(isBalanced);

        Pair pair = isBalanced2(root);
        System.out.println(pair.isBalanced);
    }

}

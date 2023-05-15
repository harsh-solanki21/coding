package Tree.BinaryTree;

public class IsTreeBST {

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

    static class BSTPair {
        boolean isBST;
        int min;
        int max;
    }

    static BSTPair isBST(Node node) {
        if (node == null) {
            BSTPair basePair = new BSTPair();
            basePair.min = Integer.MAX_VALUE;
            basePair.max = Integer.MIN_VALUE;
            basePair.isBST = true;
            return basePair;
        }

        BSTPair leftPair = isBST(node.left);
        BSTPair rightPair = isBST(node.right);

        BSTPair pair = new BSTPair();
        pair.isBST = leftPair.isBST && rightPair.isBST && (node.data >= leftPair.max && node.data <= rightPair.min);
        pair.min = Math.min(node.data, Math.min(leftPair.min, rightPair.min));
        pair.max = Math.max(node.data, Math.max(leftPair.max, rightPair.max));

        return pair;

    }


    public static void main(String[] args) {
        root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);

        BSTPair pair = isBST(root);
        System.out.println(pair.isBST);
    }

}

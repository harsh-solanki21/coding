package Tree.BinaryTree;

public class LargestBSTSubtree {

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
        Node root;  // largestBSTRoot
        int size;  // largestBSTSize
    }

    static BSTPair largestBSTSubtree(Node node) {
        if (node == null) {
            BSTPair basePair = new BSTPair();
            basePair.min = Integer.MAX_VALUE;
            basePair.max = Integer.MIN_VALUE;
            basePair.isBST = true;
            basePair.root = null;
            basePair.size = 0;
            return basePair;
        }

        BSTPair leftPair = largestBSTSubtree(node.left);
        BSTPair rightPair = largestBSTSubtree(node.right);

        BSTPair pair = new BSTPair();
        pair.isBST = leftPair.isBST && rightPair.isBST && (node.data >= leftPair.max && node.data <= rightPair.min);
        pair.min = Math.min(node.data, Math.min(leftPair.min, rightPair.min));
        pair.max = Math.max(node.data, Math.max(leftPair.max, rightPair.max));

        if (pair.isBST) {
            pair.root = node;
            pair.size = leftPair.size + rightPair.size + 1;
        } else if (leftPair.size > rightPair.size) {
            pair.root = leftPair.root;
            pair.size = leftPair.size;
        } else {
            pair.root = rightPair.root;
            pair.size = rightPair.size;
        }

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
        root.left.right.left = new Node(30);
        root.left.right.right = new Node(40);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(77);
        root.right.left.left.left = new Node(51);
        root.right.left.left.right = new Node(61);
        root.right.left.right.left = new Node(74);
        root.right.left.right.right = new Node(78);

        BSTPair pair = largestBSTSubtree(root);
        System.out.println("Root of largest BST Subtree: " + pair.root.data);
        System.out.println("Size of largest BST Subtree: " + pair.size);
    }

}

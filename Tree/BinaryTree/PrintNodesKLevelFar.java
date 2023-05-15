package Tree.BinaryTree;

import java.util.ArrayList;

public class PrintNodesKLevelFar {

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

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }


    static void printKNodesFar(Node node, int data, int k) {
        path = new ArrayList<>();
        findAndNodeToPath(node, data);
        for (int i = 0; i < path.size(); i++) {
            printNodesOfKthLevel(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
        }
    }


    // Print nodes at Kth level
    static void printNodesOfKthLevel(Node node, int k, Node blocker) {
        if (node == null || k < 0 || node == blocker) {
            return;
        }

        if (k == 0) {
            System.out.print(node.data + " ");
        }

        printNodesOfKthLevel(node.left, k - 1, blocker);
        printNodesOfKthLevel(node.right, k - 1, blocker);
    }


    // Find and Node to root path
    static ArrayList<Node> path;

    static boolean findAndNodeToPath(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            path.add(node);
            return true;
        }

        boolean left = findAndNodeToPath(node.left, data);
        if (left) {
            path.add(node);
            return true;
        }

        boolean right = findAndNodeToPath(node.right, data);
        if (right) {
            path.add(node);
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.left.left.left.left = new Node(12);
        root.left.left.left.right = new Node(13);
        root.left.left.right.left = new Node(14);
        root.left.left.right.right = new Node(15);
        root.left.right.left.left = new Node(16);
        root.left.right.left.right = new Node(17);
        root.left.right.right.left = new Node(18);
        root.left.right.right.right = new Node(19);
        root.left.left.right.right.left = new Node(20);
        root.left.left.right.right.right = new Node(21);
        root.left.left.right.right.left.left = new Node(22);
        root.left.left.right.right.left.right = new Node(23);
        root.left.left.right.right.right.left = new Node(24);
        root.left.left.right.right.right.right = new Node(25);
        root.left.left.right.right.left.left.left = new Node(26);
        root.left.left.right.right.left.left.right = new Node(27);
        root.left.left.right.right.left.right.left = new Node(28);
        root.left.left.right.right.left.right.right = new Node(29);
        root.left.left.right.right.right.left.left = new Node(30);
        root.left.left.right.right.right.left.right = new Node(31);
        root.left.left.right.right.right.right.left = new Node(32);
        root.left.left.right.right.right.right.right = new Node(33);
        root.left.left.right.right.left.left.right.left = new Node(34);
        root.left.left.right.right.left.left.right.right = new Node(35);
        root.left.left.right.right.left.right.left.left = new Node(36);
        root.left.left.right.right.left.right.left.right = new Node(37);

        int data = 15;
        int k = 3;

        printKNodesFar(root, data, k);
    }

}

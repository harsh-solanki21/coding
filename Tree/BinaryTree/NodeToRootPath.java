package Tree.BinaryTree;

import java.util.ArrayList;

public class NodeToRootPath {

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
    static ArrayList<Integer> path = new ArrayList<>();

    static boolean findAndNodeToPath(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            path.add(node.data);
            return true;
        }

        boolean left = findAndNodeToPath(node.left, data);
        if (left) {
            path.add(node.data);
            return true;
        }

        boolean right = findAndNodeToPath(node.right, data);
        if (right) {
            path.add(node.data);
            return true;
        }

        return false;
    }


    // Approach 2
    static String ans = "";

    static void nodeToRoot(Node root, int val, String path) {
        if (root == null) {
            return;
        }
        if (root.data == val) {
            ans = path + root.data;
            return;
        }
        if (root.left != null) {
            nodeToRoot(root.left, val, path + root.data + "->");
        }
        if (root.right != null) {
            nodeToRoot(root.right, val, path + root.data + "->");
        }
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
        root.right.left.right = new Node(70);

        findAndNodeToPath(root, 30);
        System.out.println(path);

        nodeToRoot(root, 30, "");
        System.out.println(ans);
    }

}

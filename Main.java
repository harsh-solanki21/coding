import java.util.*;

public class Main {

    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);
        int dia = height(root.left) + height(root.right) + 1;
        return Math.max(dia, Math.max(left, right));
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
        root.left.right.right = new Node(9);
        root.left.left.right.right = new Node(10);
        root.left.right.right.left = new Node(11);
        root.left.left.right.right.left = new Node(12);
        root.left.right.right.left.right = new Node(13);
        root.left.left.right.right.left.left = new Node(14);

        System.out.println(diameter(root));
    }

}


// Tree

// Diameter of Binary Tree
// Lowest Common Ancestor
// Kth Smallest element in BST

//        root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.left.left.left = new Node(7);
//        root.left.left.right = new Node(8);
//        root.left.right.right = new Node(9);
//        root.left.left.right.right = new Node(10);
//        root.left.right.right.left = new Node(11);
//        root.left.left.right.right.left = new Node(12);
//        root.left.right.right.left.right = new Node(13);
//        root.left.left.right.right.left.left = new Node(14);

//        root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(5);
//        root.left.left = new Node(3);
//        root.left.right = new Node(4);
//        root.right.right = new Node(6);
//        root.left.left.left = new Node(7);
//        root.left.left.right = new Node(8);
//        root.left.right.left = new Node(10);
//        root.left.left.right.right = new Node(9);

//        Node ans = lowestCommonAncestor(root, root.left.left.left, root.left.left.right.right);
//        System.out.println(ans.data);

//        System.out.println(diameter(root));

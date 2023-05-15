package Tree.BinarySearchTree;

public class SizeSumMaxMinFind {

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


    // Size and sum will be the same as binary tree because they depend on the structure
    static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return leftSize + rightSize + 1;
    }

    static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        return leftSum + rightSum + node.data;
    }


    static int max(Node node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    static int min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }
    }

    static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
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
        root.right.right.left = new Node(80);
        root.right.right.left.left = new Node(78);
        root.right.right.left.right = new Node(82);

        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(min(root));
        System.out.println(find(root, 82));
    }

}

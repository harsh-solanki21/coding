package Tree.BinarySearchTree;

public class LowestCommonAncestor {

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


    // Lowest Common Ancestor of BST
    static int lca(Node node, int data1, int data2) {
        if (data1 < node.data && data2 < node.data) {
            return lca(node.left, data1, data2);
        }
        else if (data1 > node.data && data2 > node.data) {
            return lca(node.right, data1, data2);
        }
        else {
            return node.data;
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
        root.right.right.right = new Node(85);
        root.right.right.left.left = new Node(78);
        root.right.right.left.right = new Node(82);

        System.out.println(lca(root, 85, 78));
    }

}

package Tree.BinaryTree;

public class SizeSumMaxHeightDiameter {

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

    // The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    // Approach - 1 with TC - O(n^2)
    static int diameter1(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameter1(root.left);
        int rightDiameter = diameter1(root.right);
        int diameter = height(root.left) + height(root.right) + 1;  // +1 for root node (if you consider edges then +2)
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }

    // Approach - 2 with TC - O(n)
    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diameter1 = left.diameter;
        int diameter2 = right.diameter;
        int diameter3 = left.height + right.height + 1;

        int myDiameter = Math.max(Math.max(diameter1, diameter2), diameter3);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiameter);
        return myInfo;
    }


    public static void main(String[] args) {
        SizeSumMaxHeightDiameter tree = new SizeSumMaxHeightDiameter();
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
        System.out.println(max(tree.root));
        System.out.println(height(tree.root));
        System.out.println(diameter1(tree.root));
        System.out.println(diameter2(tree.root).diameter);
    }

}

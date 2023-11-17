package Tree.BinaryTree.MAANG_Ques;

public class Diameter {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    // The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    // Approach 1 => TC - O(n^2)
    static int diameter1(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameter1(root.left);
        int rightDiameter = diameter1(root.right);
        int diameter = height(root.left) + height(root.right) + 1;  // +1 for root node, +2 for edges
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;   // 0 for nodes, -1 for edges
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    // Approach 2 => TC - O(n)
    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    static int diameter2(Node root) {
        TreeInfo ans = diameterHelper(root);
        return ans.diameter;
    }

    private static TreeInfo diameterHelper(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);  // height 0 for nodes, -1 for edges
        }
        TreeInfo left = diameterHelper(root.left);
        TreeInfo right = diameterHelper(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diameter1 = left.diameter;
        int diameter2 = right.diameter;
        int diameter3 = left.height + right.height + 1;  // +1 for root node (if you consider edges then +2)

        int myDiameter = Math.max(Math.max(diameter1, diameter2), diameter3);

        return new TreeInfo(myHeight, myDiameter);
    }


    // Approach 3
    static int diameter = 0;

    static int diameter3(Node root) {
        diaHeight(root);
        return diameter - 1;
    }

    private static int diaHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = diaHeight(node.left);
        int rightHeight = diaHeight(node.right);
        int dia = leftHeight + rightHeight + 1;

        diameter = Math.max(diameter, dia);
        return Math.max(leftHeight, rightHeight) + 1;
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

        System.out.println(diameter1(root));
        System.out.println(diameter2(root));
        System.out.println(diameter3(root));
    }

}

package Tree.BinaryTree;

public class PathSum {

    static Node root;

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static boolean hasPathSum(Node node, int targetSum) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null && node.val == targetSum) {
            return true;
        }

        return hasPathSum(node.left, targetSum - node.val) || hasPathSum(node.right, targetSum - node.val);
    }

    public static void main(String[] args) {
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.right.right = new Node(1);

        int target = 22;
        System.out.println(hasPathSum(root, target));
    }

}

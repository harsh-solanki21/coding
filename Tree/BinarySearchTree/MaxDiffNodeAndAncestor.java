package Tree.BinarySearchTree;

public class MaxDiffNodeAndAncestor {

    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }


    // Maximum Difference Between Node and Ancestor
    static int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    private static int helper(TreeNode node, int max, int min) {
        if (node == null) {
            return max - min;
        }

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        int l = helper(node.left, max, min);
        int r = helper(node.right, max, min);

        return Math.max(l, r);
    }


    public static void main(String[] args) {
        root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);

        System.out.println(maxAncestorDiff(root));
    }

}

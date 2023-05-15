package Tree.BinaryTree;

public class CountGoodNodes {

    // https://leetcode.com/problems/count-good-nodes-in-binary-tree/

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        count += dfs(root.left, root.val);
        count += dfs(root.right, root.val);

        return count;
    }

    private static int dfs(TreeNode root, int currentMax) {
        int amount = 0;
        if (root == null) {
            return 0;
        }
        if (root.val >= currentMax) {
            amount++;
            currentMax = root.val;
        }

        amount += dfs(root.left, currentMax);
        amount += dfs(root.right, currentMax);

        return amount;
    }

}

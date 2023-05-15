package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    // https://leetcode.com/problems/path-sum-ii/

    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, targetSum, res, list);
        return res;
    }

    private static void dfs(TreeNode root, int ts, List<List<Integer>> res, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);

        // Found a leaf node, if targetSum becomes zero after adding leaf node value then a path is found, add the path to the result list
        if (root.left == null && root.right == null) {
            if ((ts - root.val) == 0) res.add(new ArrayList<>(list));
            return;
        }

        // Traverse left part(reduce targetSum by node value), and backtrack (by deleting node from list) after completing the left subtree
        if (root.left != null) {
            dfs(root.left, ts - root.val, res, list);
            list.remove(list.size() - 1);
        }

        // Traverse right part and backtrack
        if (root.right != null) {
            dfs(root.right, ts - root.val, res, list);
            list.remove(list.size() - 1);
        }

    }


    public static void main(String[] args) {
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        System.out.println(pathSum(root, targetSum));
    }

}

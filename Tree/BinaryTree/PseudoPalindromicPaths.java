package Tree.BinaryTree;

public class PseudoPalindromicPaths {

    // https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static int ans = 0;

    static int pseudoPalindromicPaths(Node root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    private static void dfs(Node root, int count) {
        if (root == null) {
            return;
        }

        count ^= 1 << (root.val - 1);
        dfs(root.left, count);
        dfs(root.right, count);
        if (root.left == null && root.right == null && (count & (count - 1)) == 0) {
            ans++;
        }
    }

}

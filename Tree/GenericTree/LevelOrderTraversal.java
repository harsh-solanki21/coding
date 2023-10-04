package Tree.GenericTree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

    static class Node {
        int val;
        List<Node> children;

        Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(root, 0, ans);
        return ans;
    }

    private static void solve(Node root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        // When found a new level, add a new list
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }

        // Add node in the list at the related level
        res.get(level).add(root.val);

        // Traverse all the children
        for (Node n : root.children) {
            solve(n, level + 1, res);
        }
    }

}

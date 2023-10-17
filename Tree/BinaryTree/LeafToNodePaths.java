package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeafToNodePaths {

    static Node root;

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static List<String> binaryTreePaths(Node root) {
        List<String> ans = new ArrayList<>();
        if (root != null) {
            searchBT(root, "", ans);
        }
        return ans;
    }

    private static void searchBT(Node root, String path, List<String> ans) {
        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", ans);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", ans);
        }
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);

        System.out.println(binaryTreePaths(root));
    }

}

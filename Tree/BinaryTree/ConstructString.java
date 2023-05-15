package Tree.BinaryTree;

public class ConstructString {

    // https://leetcode.com/problems/construct-string-from-binary-tree/

    static Node root;

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }


    static String ans = "";

    static String tree2str(Node root) {
        helper(root);
        return ans;
    }

    private static void helper(Node root) {
        if (root.left == null && root.right == null) {
            ans += root.val;
            return;
        }

        ans += root.val;
        if (root.left != null) {
            ans += "(";
            helper(root.left);
            ans += ")";
        }
        if (root.left == null && root.right != null) {
            ans += "()";
        }
        if (root.right != null) {
            ans += "(";
            helper(root.right);
            ans += ")";
        }

    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println(tree2str(root));
    }

}

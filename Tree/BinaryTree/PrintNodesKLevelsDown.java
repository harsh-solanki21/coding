package Tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PrintNodesKLevelsDown {

    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // BFS
    static List<Integer> printKLevelsDownBFS(Node root, int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        int currentLevel = 0;

        while (!q.isEmpty()) {
            int currentSize = q.size();
            for (int i = 0; i < currentSize; i++) {
                Node node = q.remove();
                if (currentLevel == k) {
                    ans.add(node.data);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            currentLevel++;
        }

        return ans;
    }


    // DFS
    static List<Integer> printKLevelsDownDFS(Node root, int k) {
        List<Integer> ans = new ArrayList<>();
        helper(root, k, ans);
        return ans;
    }

    private static void helper(Node node, int k, List<Integer> ans) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            ans.add(node.data);
        }
        helper(node.left, k - 1, ans);
        helper(node.right, k - 1, ans);
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

        System.out.println(printKLevelsDownBFS(root, 3));
        System.out.println(printKLevelsDownDFS(root, 3));
    }

}

package Tree.BinaryTree.MAANG_Ques;

import java.util.ArrayList;

public class PathSum3 {

    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // https://leetcode.com/problems/path-sum-iii/description/
    static int pathSum(Node root, long targetSum) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int[] count = new int[1];
        helper(root, targetSum, count, path);
        return count[0];
    }

    private static void helper(Node root, long targetSum, int[] count, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        long sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) {
                count[0]++;
            }
        }
        helper(root.left, targetSum, count, path);
        helper(root.right, targetSum, count, path);
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right.right = new Node(11);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);

        int targetSum = 8;
        System.out.println(pathSum(root, targetSum));
    }

}

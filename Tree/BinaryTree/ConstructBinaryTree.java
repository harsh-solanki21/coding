package Tree.BinaryTree;

import java.util.Stack;

public class ConstructBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? ". " : node.left.data;
        str += " <- " + node.data + " -> ";
        str += node.right == null ? ". " : node.right.data;
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // Construct a binary tree
    static void constructBinaryTree(Integer[] nums) {
        Node root = new Node(nums[0], null, null);
        Pair rootPair = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rootPair);

        int idx = 0;
        while (!st.isEmpty()) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (nums[idx] != null) {
                    top.node.left = new Node(nums[idx], null, null);
                    Pair leftPair = new Pair(top.node.left, 1);
                    st.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (nums[idx] != null) {
                    top.node.right = new Node(nums[idx], null, null);
                    Pair rightPair = new Pair(top.node.right, 1);
                    st.push(rightPair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }

        display(root);
    }

    public static void main(String[] args) {
        Integer[] nums = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        // Used Integer instead of int because for support of null

        constructBinaryTree(nums);
    }

}

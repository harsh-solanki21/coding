package Tree.SegmentTree;

public class SegmentTree {

    // A segment tree is a data structure used to store information about array segments and answer segment queries efficiently.

    // There are two main operations performed on a segment tree:
    // 1. range(i, j): gives the sum of the array elements starting at index i and ending at index j.
    // 2. update(i, val): updates the value at index i to the val in the original array and updates the segment tree accordingly.

    // Both range(i, j) and update(i, val) take log(n) time, where n is the number of elements in the segment tree.

    // Segment Tree is Full Binary Tree (Every node except the leaf node has 2 children)

    Node root;

    static class Node {
        int data, startInterval, endInterval;
        Node left, right;

        Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public SegmentTree(int[] nums) {
        this.root = constructTree(nums, 0, nums.length - 1);
    }

    private Node constructTree(int[] nums, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = nums[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        node.left = constructTree(nums, start, mid);
        node.right = constructTree(nums, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and Data: " + node.left.data + " => ";
        } else {
            str += "null";
        }

        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and Data: " + node.data + " => ";

        if (node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and Data: " + node.right.data + " => ";
        } else {
            str += "null";
        }
    }

    // qsi - queryStartIndex, qei - queryEndIndex
    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            // range represented by a node is completely inside the given range
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            // range represented by a node is completely outside the given range
            return 0;
        } else {
            // range represented by a node is partially inside and partially outside the given range
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
            } else {
                int left = update(node.left, index, value);
                int right = update(node.right, index, value);
                node.data = left + right;
            }
            return node.data;
        }
        return node.data;
    }

    public static void main(String[] args) {
        int[] nums = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(nums);
        tree.display(tree.root);
    }

}

package Tree.BinarySearchTree;

public class ConvertSortedArrayToBST {

    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void display(Node node) {
        if (node == null) {
            return;
        }

        display(node.left);
        System.out.print(node.data + " ");
        display(node.right);
    }

    // DFS: pre-order
    // TC - O(n), SC - O(log n)
    static Node sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static Node helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (right + left) / 2;
        Node root = new Node(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }


    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Node ans = sortedArrayToBST(nums);
        display(ans);
    }

}

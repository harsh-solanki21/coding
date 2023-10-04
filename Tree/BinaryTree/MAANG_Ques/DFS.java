package Tree.BinaryTree.MAANG_Ques;

public class DFS {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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


    // Invert Binary Tree
    static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    // Maximum Depth of Binary Tree
    static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


    // Convert Sorted Array to Binary Search Tree
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


    // Flatten Binary Tree to Linked List
    static void flatten(Node root) {

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

//        Node invertedRoot = invertTree(root);
//        display(invertedRoot);

//        System.out.println(maxDepth(root));

//        int[] nums = {-10, -3, 0, 5, 9};
//        Node root = sortedArrayToBST(nums);
//        display(root);

        flatten(root);
    }

}

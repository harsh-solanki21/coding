package Tree.BinarySearchTree;

public class ConstructBST {

    // Structure of Binary Tree and BST is the same
    // Code to find Size, Sum, Diameter will be the same as Binary Tree
    // But Min, Max, Find will be different because of the properties of BST,
    // BST will do it in O(log n), but Binary Tree will take O(n)

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
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

    static void displayInorder(Node node) {
        if (node == null) {
            return;
        }

        displayInorder(node.left);
        System.out.print(node.data + " ");
        displayInorder(node.right);
    }


    // Construct a BST with root as middle
    static Node constructBSTMiddle(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = (lo + hi) / 2;

        int data = nums[mid];
        Node leftChild = constructBSTMiddle(nums, lo, mid - 1);
        Node rightChild = constructBSTMiddle(nums, mid + 1, hi);

        Node node = new Node(data, leftChild, rightChild);
        return node;
    }


    // Construct BST by comparing elements
    // TC - O(h)
    static Node constructBST(Node node, int val) {
        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (node.data > val) {
            node.left = constructBST(node.left, val);
        } else {
            node.right = constructBST(node.right, val);
        }

        return node;
    }


    public static void main(String[] args) {
        int[] nums = {12, 25, 37, 50, 62, 75, 87};

//        Node node = constructBSTMiddle(nums, 0, nums.length - 1);
//        display(node);

        Node root = null;
        for (int i = 0; i < nums.length; i++) {
            root = constructBST(root, nums[i]);
        }
        displayInorder(root);
    }

}

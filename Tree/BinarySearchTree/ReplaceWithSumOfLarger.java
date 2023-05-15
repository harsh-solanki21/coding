package Tree.BinarySearchTree;

public class ReplaceWithSumOfLarger {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void display(Node node) {
        if (node == null) {
            System.out.print("n ");
            return;
        }

        System.out.print(node.data + " ");
        display(node.left);
        display(node.right);
    }


    // Replace data of the node with the sum of all the elements larger than itself present in the tree
    // Hint - Inorder of BST visits node in sorted order
    // Reverse of Inorder will be helpful here
    static int sum = 0;

    static void replaceWithSumOfLarger(Node node) {
        if (node == null) {
            return;
        }

        replaceWithSumOfLarger(node.right);
        int originalData = node.data;
        node.data = sum;
        sum += originalData;
        replaceWithSumOfLarger(node.left);
    }


    public static void main(String[] args) {
        root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        root.left.right.left = new Node(30);
        root.left.right.right = new Node(40);

        display(root);
        System.out.println();
        replaceWithSumOfLarger(root);
        display(root);
    }

}

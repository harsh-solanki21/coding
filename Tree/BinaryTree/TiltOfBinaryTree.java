package Tree.BinaryTree;

public class TiltOfBinaryTree {

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


    static int tilt = 0;

    static int tilt(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = tilt(node.left);
        int rightSum = tilt(node.right);

        int localTilt = Math.abs(leftSum - rightSum);
        tilt += localTilt;

        return leftSum + rightSum + node.data;
    }


    public static void main(String[] args) {
        root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(12);
        root.left.right = new Node(17);
        root.right.left = new Node(14);
        root.right.right = new Node(9);
        root.left.right.left = new Node(8);

        System.out.println(tilt(root));
    }

}

package Tree.BinaryTree;

public class VerticalOrderPrint {

    static Node root;
    static int max, min;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    private static void findMinMax(Node node, int hd) {
        if (node == null) {
            return;
        }

        if (hd < min) {
            min = hd;
        } else if (hd > max) {
            max = hd;
        }

        findMinMax(node.left, hd - 1);
        findMinMax(node.right, hd + 1);
    }

    private static void printVerticalLine(Node node, int i, int hd) {
        if (node == null) {
            return;
        }
        if (hd == i) {
            System.out.print(node.data + " ");
        }

        printVerticalLine(node.left, i, hd - 1);
        printVerticalLine(node.right, i, hd + 1);
    }

    static void verticalOrder(Node node) {
        findMinMax(node, 0);
        for (int i = min; i <= max; i++) {
            printVerticalLine(node, i, 0);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        verticalOrder(root);

    }

}

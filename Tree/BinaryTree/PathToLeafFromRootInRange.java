package Tree.BinaryTree;

public class PathToLeafFromRootInRange {

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


    static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            sum += node.data;
            if (sum >= lo && sum <= hi) {
                System.out.println(path + node.data);
                System.out.println(sum);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " -> ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " -> ", sum + node.data, lo, hi);
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
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);

        int lo = 150;
        int hi = 250;
        pathToLeafFromRoot(root, "", 0, lo, hi);
    }

}

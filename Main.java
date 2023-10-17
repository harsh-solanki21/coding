import java.util.*;

public class Main {

    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        Node node;
        int count;

        Pair(Node node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    // https://www.youtube.com/watch?v=9D-vP-jcc-Y
    // https://www.youtube.com/watch?v=1Kyc-zQS7eQ&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=19
    static List<Integer> nodeToRootPath(Node root, int target) {
        List<Integer> ans = new ArrayList<>();
        return ans;
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

        System.out.println(nodeToRootPath(root, 12));
    }

}
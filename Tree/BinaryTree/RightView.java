package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightView {

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

    // Right View
    static List<Integer> rightSideView(Node root) {
        List<Integer> list = new ArrayList<>();
        rightView(root, list, 0);
        return list;
    }

    private static void rightView(Node root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.data);
        }

        rightView(root.right, list, level + 1);
        rightView(root.left, list, level + 1);
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println(rightSideView(root));
    }

}

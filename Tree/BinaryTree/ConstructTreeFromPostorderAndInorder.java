package Tree.BinaryTree;

import java.util.HashMap;

public class ConstructTreeFromPostorderAndInorder {

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
        System.out.print(node.data + " ");
        display(node.left);
        display(node.right);
    }


    static HashMap<Integer, Integer> mp = new HashMap<>();
    static int index;

    static Node buildUtil(int[] in, int[] post, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int curr = post[index];
        Node node = new Node(curr);
        index--;

        if (inStart == inEnd) {
            return node;
        }

        int iIndex = mp.get(curr);
        node.right = buildUtil(in, post, iIndex + 1, inEnd);
        node.left = buildUtil(in, post, inStart, iIndex - 1);

        return node;
    }

    static Node buildTree(int[] in, int[] post, int inLen) {
        for (int i = 0; i < inLen; i++) {
            mp.put(in[i], i);
        }
        index = inLen - 1;
        return buildUtil(in, post, 0, inLen - 1);
    }


    public static void main(String[] args) {
        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};

        Node root = buildTree(in, post, in.length);

        System.out.println("Preorder of the constructed tree: ");
        display(root);
    }

}

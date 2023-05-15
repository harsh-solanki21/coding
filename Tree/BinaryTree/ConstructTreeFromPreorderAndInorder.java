package Tree.BinaryTree;

import java.util.HashMap;

public class ConstructTreeFromPreorderAndInorder {

    static class Node {
        char data;
        Node left, right;

        Node(char data) {
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

    static Node root;
    static HashMap<Character, Integer> mp = new HashMap<>();
    static int preIndex = 0;

    public static Node buildTree(char[] in, char[] pre, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        char curr = pre[preIndex++];
        Node node = new Node(curr);

        if (inStart == inEnd) {
            return node;
        }

        int inIndex = mp.get(curr);
        node.left = buildTree(in, pre, inStart, inIndex - 1);
        node.right = buildTree(in, pre, inIndex + 1, inEnd);

        return node;
    }


    static Node buildTreeWrap(char[] in, char[] pre, int inLen) {
        for (int i = 0; i < inLen; i++) {
            mp.put(in[i], i);
        }
        return buildTree(in, pre, 0, inLen - 1);
    }


    public static void main(String[] args) {
        char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};

        root = buildTreeWrap(in, pre, in.length);

        System.out.println("Inorder traversal of the constructed tree is: ");
        display(root);
    }

}

package Tree.BinaryTree;

public class ConstructTreeFromPreorderAndPostorder {

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
        display(node.left);
        System.out.print(node.data + " ");
        display(node.right);
    }


    static int preindex;

    static Node constructTreeUtil(int[] pre, int[] post, int l, int h, int size) {
        if (preindex >= size || l > h) {
            return null;
        }

        Node root = new Node(pre[preindex]);
        preindex++;

        if (l == h || preindex >= size) {
            return root;
        }

        int i;
        for (i = l; i <= h; i++) {
            if (post[i] == pre[preindex])
                break;
        }

        if (i <= h) {
            root.left = constructTreeUtil(pre, post, l, i, size);
            root.right = constructTreeUtil(pre, post, i + 1, h - 1, size);
        }

        return root;
    }

    static Node constructTree(int[] pre, int[] post, int preLen) {
        preindex = 0;
        return constructTreeUtil(pre, post, 0, preLen - 1, preLen);
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] post = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        Node root = constructTree(pre, post, pre.length);

        System.out.println("Inorder traversal of the constructed tree: ");
        display(root);
    }

}

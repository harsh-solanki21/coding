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

    static void preInPost(Node root) {
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            if (st.peek().count == 1) {
                pre.append(st.peek().node.data).append(" ");
                st.peek().count = 2;
                if (st.peek().node.left != null) {
                    st.push(new Pair(st.peek().node.left, 1));
                }
            } else if (st.peek().count == 2) {
                in.append(st.peek().node.data).append(" ");
                st.peek().count = 3;
                if (st.peek().node.right != null) {
                    st.push(new Pair(st.peek().node.right, 1));
                }
            } else {
                post.append(st.pop().node.data).append(" ");
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
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

        preInPost(root);
    }

}
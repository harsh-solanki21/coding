package Tree.BinaryTree.Concept;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraversalsIterative {

    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Preorder
    // TC - O(n), SC - O(h) where h is the height of the tree
    void preorder(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.empty()) {
            Node mynode = st.peek();
            System.out.print(mynode.data + " ");
            st.pop();

            if (mynode.right != null) {
                st.push(mynode.right);
            }
            if (mynode.left != null) {
                st.push(mynode.left);
            }
        }
    }


    // Inorder
    // TC - O(n), SC - O(n)
    void inorder() {
        if (root == null) {
            return;
        }

        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }


    // Postorder using 2 stacks
    // TC - O(n), SC - O(n)
    void postorder(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if (root == null) {
            return;
        }
        s1.push(root);

        while (!s1.isEmpty()) {
            Node temp = s1.pop();
            s2.push(temp);
            if (temp.left != null) {
                s1.push(temp.left);
            }
            if (temp.right != null) {
                s1.push(temp.right);
            }
        }

        while (!s2.isEmpty()) {
            Node temp = s2.pop();
            System.out.print(temp.data + " ");
        }
    }


    // Postorder using single stack
    void postorderSingleStack(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            if (stack.empty()) {
                return;
            }
            root = stack.pop();

            if (!stack.empty() && stack.peek() == root) {
                root = root.right;
            } else {
                System.out.print(root.data + " ");
                root = null;
            }
        }
    }


    // Level Order using Queue
    // TC - O(n), SC - O(n)
    void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }


    // Another approach for Iterative traversal in pre, in and post order
    // All traversals in single code
    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    void iterativePreInPostTraversal(Node node) {
        Stack<Pair> st = new Stack<>();
        Pair rootPair = new Pair(node, 1);
        st.push(rootPair);

        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();

        while (!st.isEmpty()) {
            Pair top = st.peek();
            if (top.state == 1) {  // pre, state++, go left
                pre.append(top.node.data).append(" ");
                top.state++;

                if (top.node.left != null) {
                    Pair leftPair = new Pair(top.node.left, 1);
                    st.push(leftPair);
                }
            } else if (top.state == 2) {  // in, state++, go right
                in.append(top.node.data).append(" ");
                top.state++;

                if (top.node.right != null) {
                    Pair rightPair = new Pair(top.node.right, 1);
                    st.push(rightPair);
                }
            } else {  // post, pop
                post.append(top.node.data).append(" ");
                st.pop();
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }


    public static void main(String[] args) {
        TraversalsIterative tree = new TraversalsIterative();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

//        tree.preorder(tree.root);
//        tree.inorder();
//        tree.postorder(tree.root);  // 2 stacks
//        tree.postorderSingleStack(tree.root);  // single stack
//        tree.levelOrder();

        tree.iterativePreInPostTraversal(tree.root);
    }

}

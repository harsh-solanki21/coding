package Tree.BinaryTree.Concept;

import java.util.ArrayDeque;
import java.util.Queue;

public class TraversalsRecursive {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        static Node buildTree(int[] nodes) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }


    // DFS Traversals
    // PreOrder traversal = Root, Left Subtree, Right Subtree
    // TC - O(n), SC - O(n)
    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    // InOrder traversal = Left Subtree, Root, Right Subtree
    // It gives sorted order elements in BST
    // TC - O(n), SC - O(n)
    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    // PostOrder traversal = Left Subtree, Right Subtree, Root
    // TC - O(n), SC - O(n)
    static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }


    // BFS Traversal
    // LevelOrder traversal = Level-wise traversal
    // TC - O(n), SC - O(n)
    static void levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                root = q.remove();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);
        preOrder(root);
        inOrder(root);
        postOrder(root);
        levelOrder(root);
    }

}

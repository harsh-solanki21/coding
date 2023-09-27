package Tree.BinaryTree;

import java.util.*;

public class BFS_MAANG {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    // BFS/Level-Order Traversal
    static List<List<Integer>> bfsTraversal() {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node current = q.remove();
                currentLevel.add(current.data);
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            ans.add(currentLevel);
        }

        return ans;
    }


    // Average of levels
    static List<Double> averageOfLevels(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Double> ans = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.remove();
                levelSum += current.data;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            ans.add(levelSum / levelSize);
        }

        return ans;
    }


    // Level Order Successor of a node
    static Node findSuccessor(Node root, int key) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            if (currentNode.data == key) {
                break;
            }
        }

        return queue.peek();
    }


    // Zigzag Level Order Traversal
    static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<Node> q = new ArrayDeque<>();
        q.add(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (!reverse) {
                    Node current = q.removeFirst();
                    currentLevel.add(current.data);
                    if (current.left != null) {
                        q.addLast(current.left);
                    }
                    if (current.right != null) {
                        q.addLast(current.right);
                    }
                } else {
                    Node current = q.removeLast();
                    currentLevel.add(current.data);
                    if (current.right != null) {
                        q.addFirst(current.right);
                    }
                    if (current.left != null) {
                        q.addFirst(current.left);
                    }
                }
            }
            reverse = !reverse;
            ans.add(currentLevel);
        }

        return ans;
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.right.left.left = new Node(10);
        root.right.right.right = new Node(11);

//        List<List<Integer>> ans = bfsTraversal();
//        System.out.println(ans);

//        System.out.println(averageOfLevels(root));

        List<List<Integer>> ans = zigzagLevelOrder(root);
        System.out.println(ans);
    }

}

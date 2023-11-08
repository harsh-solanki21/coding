package Tree.BinaryTree;

import java.util.*;

public class PrintNodesKLevelsFar {

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


    // Solution 1
    // TC - O(n), SC - O(n)
    static List<Integer> distanceK(Node root, Node target, int k) {
        HashMap<Node, Node> parent = new HashMap<>();
        getParentsByBFS(parent, root);

        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        queue.offer(target);
        int level = 0;

        while (!queue.isEmpty()) {
            if (level == k) {
                break;
            }
            level++;
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                Node curr = queue.poll();
                if (parent.containsKey(curr) && !visited.containsKey(parent.get(curr))) {
                    visited.put(parent.get(curr), true);
                    queue.offer(parent.get(curr));
                }
                if (curr.left != null && !visited.containsKey(curr.left)) {
                    visited.put(curr.left, true);
                    queue.offer(curr.left);
                }
                if (curr.right != null && !visited.containsKey(curr.right)) {
                    visited.put(curr.right, true);
                    queue.offer(curr.right);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll().data);
        }

        return ans;
    }

    private static void getParentsByBFS(HashMap<Node, Node> parent, Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.left != null) {
                parent.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }

    private static void getParents(HashMap<Node, Node> parent, Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left, root);
        }
        if (root.right != null) {
            parent.put(root.right, root);
        }
        getParents(parent, root.left);
        getParents(parent, root.right);
    }


    // Solution 2
    static ArrayList<Node> path;

    static void printKNodesFar(Node node, int data, int k) {
        path = new ArrayList<>();
        findAndNodeToPath(node, data);

        for (int i = 0; i < path.size(); i++) {
            printNodesOfKthLevel(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
        }
    }

    private static void printNodesOfKthLevel(Node node, int k, Node blocker) {
        if (node == null || k < 0 || node == blocker) {
            return;
        }
        if (k == 0) {
            System.out.print(node.data + " ");
        }

        printNodesOfKthLevel(node.left, k - 1, blocker);
        printNodesOfKthLevel(node.right, k - 1, blocker);
    }

    private static boolean findAndNodeToPath(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            path.add(node);
            return true;
        }

        boolean left = findAndNodeToPath(node.left, data);
        if (left) {
            path.add(node);
            return true;
        }

        boolean right = findAndNodeToPath(node.right, data);
        if (right) {
            path.add(node);
            return true;
        }

        return false;
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
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.left.left.left.left = new Node(12);
        root.left.left.left.right = new Node(13);
        root.left.left.right.left = new Node(14);
        root.left.left.right.right = new Node(15);
        root.left.right.left.left = new Node(16);
        root.left.right.left.right = new Node(17);
        root.left.right.right.left = new Node(18);
        root.left.right.right.right = new Node(19);
        root.left.left.right.right.left = new Node(20);
        root.left.left.right.right.right = new Node(21);
        root.left.left.right.right.left.left = new Node(22);
        root.left.left.right.right.left.right = new Node(23);
        root.left.left.right.right.right.left = new Node(24);
        root.left.left.right.right.right.right = new Node(25);
        root.left.left.right.right.left.left.left = new Node(26);
        root.left.left.right.right.left.left.right = new Node(27);
        root.left.left.right.right.left.right.left = new Node(28);
        root.left.left.right.right.left.right.right = new Node(29);
        root.left.left.right.right.right.left.left = new Node(30);
        root.left.left.right.right.right.left.right = new Node(31);
        root.left.left.right.right.right.right.left = new Node(32);
        root.left.left.right.right.right.right.right = new Node(33);
        root.left.left.right.right.left.left.right.left = new Node(34);
        root.left.left.right.right.left.left.right.right = new Node(35);
        root.left.left.right.right.left.right.left.left = new Node(36);
        root.left.left.right.right.left.right.left.right = new Node(37);

        int target = 15;
        Node targetNode = root.left.left.right.right;
        int k = 3;

        // solution 1
        System.out.println(distanceK(root, targetNode, k));

        // solution 2
        printKNodesFar(root, target, k);
    }

}

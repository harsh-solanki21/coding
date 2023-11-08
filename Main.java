import java.util.*;

public class Main {
    // Graph
    // BFS and DFS of Graph


    // Tree
    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    // Diameter of Binary Tree
//    static int diameter(Node root) {
//    }

//    static void flatten(Node root) {
//        while (root != null) {
//            if (root.left != null) {
//                Node prev = root.left;
//                // Find the rightmost node in left subtree
//                while (prev.right != null) {
//                    prev = prev.right;
//                }
//                prev.right = root.right;
//                root.right = root.left;
//                root.left = null;
//            }
//            root = root.right;
//        }
//    }

    static void flatten(Node root) {

    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    public static void main(String[] args) {
        // Tree
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

//        flatten(root);
//        preOrder(root);

//        Node ans = lowestCommonAncestor(root, root.left.left.right.right, root.left.right.right.left);
//        System.out.println(ans.data);


//        System.out.println(diameter(root));


        // Graph
//        int vertices = 7;
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//        for (int i = 0; i < vertices; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        graph.get(0).add(1);
//        graph.get(0).add(2);
//
//        graph.get(1).add(0);
//        graph.get(1).add(3);
//        graph.get(1).add(4);
//
//        graph.get(2).add(0);
//        graph.get(2).add(3);
//
//        graph.get(3).add(1);
//        graph.get(3).add(2);
//
//        graph.get(4).add(1);
//        graph.get(4).add(5);
//        graph.get(4).add(6);
//
//        graph.get(5).add(4);
//        graph.get(5).add(6);
//
//        graph.get(6).add(4);
//        graph.get(6).add(5);
//
////        System.out.println(bfs(graph, vertices));
//
////        System.out.println(dfs(graph, vertices));

    }

}
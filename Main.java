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
//    static int diameter1(Node root) {
//
//    }


    // print nodes k level far
//    static List<Integer> distanceK(Node root, Node target, int k) {
//
//    }


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

        Node targetNode = root.left.left.right.right;
        int k = 3;

//        System.out.println(distanceK(root, targetNode, k));

//        System.out.println(diameter1(root));
//        System.out.println(diameter2(root));




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
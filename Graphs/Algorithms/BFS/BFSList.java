package Graphs.Algorithms.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSList {

    static class Edge {
        int source;
        int neighbour;

        Edge(int source, int neighbour) {
            this.source = source;
            this.neighbour = neighbour;
        }
    }

    static class Pair {
        int vertex;
        String pathSoFar;

        Pair(int vertex, String pathSoFar) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
    }


    // Tracking path so far
    static void bfs(ArrayList<ArrayList<Edge>> graph, int vertices, int source) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(source, source + ""));
        boolean[] visited = new boolean[vertices];

        while (!queue.isEmpty()) {
            // Remove - Mark Visited - Work(Print) - Add Unmarked neighbours
            Pair rem = queue.removeFirst();

            if (visited[rem.vertex]) {
                continue;
            }
            visited[rem.vertex] = true;
            System.out.println(rem.vertex + " @ " + rem.pathSoFar);

            for (Edge edge : graph.get(rem.vertex)) {
                if (!visited[edge.neighbour]) {
                    queue.add(new Pair(edge.neighbour, rem.pathSoFar + edge.neighbour));
                }
            }
        }
    }


    // Standard BFS Traversal
    static ArrayList<Integer> bfsTraversal(ArrayList<ArrayList<Integer>> graph, int vertices) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            ans.add(vertex);
            for (int i : graph.get(vertex)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int vertices = 7;
//        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
//
//        // vertices
//        for (int i = 0; i < vertices; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        // Edges
//        graph.get(0).add(new Edge(0, 1));
//        graph.get(1).add(new Edge(1, 2));
//        graph.get(2).add(new Edge(2, 3));
//        graph.get(0).add(new Edge(0, 3));
//        graph.get(3).add(new Edge(3, 4));
//        graph.get(4).add(new Edge(4, 5));
//        graph.get(5).add(new Edge(5, 6));
//        graph.get(4).add(new Edge(4, 6));
//
//        // also need to add this because of undirected graph
//        graph.get(1).add(new Edge(1, 0));
//        graph.get(2).add(new Edge(2, 1));
//        graph.get(3).add(new Edge(3, 2));
//        graph.get(3).add(new Edge(3, 0));
//        graph.get(4).add(new Edge(4, 3));
//        graph.get(5).add(new Edge(5, 4));
//        graph.get(6).add(new Edge(6, 5));
//        graph.get(6).add(new Edge(6, 4));
//
//        int source = 0;
//
//        // with path so far from source to destination
//        bfs(graph, vertices, source);


        // Standard BFS
        // Time Complexity: O(V) + O(2E) = O(V + E)
        // Space Complexity: O(3V) = O(V)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        /*
                1 ---- 3
              /        |  \
             0         |    5 --- 6
              \        |  /
                2 ---- 4
        */
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(2);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(3);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(5);

        System.out.println(bfsTraversal(adj, vertices));

    }

}

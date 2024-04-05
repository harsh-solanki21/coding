package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsMST {

    // Kruskal's Algorithm finds MST in an Undirected Graph.
    // It falls under a class of algorithms called Greedy Algorithms that find the local optimum in the hope of finding a global optimum.

    // The MSTs found by Kruskal's algorithm is the collection of edges that connect all vertices with the minimum total edge weight.
    // Kruskal's algorithm start from the edges with the lowest weight and keep adding edges until we reach our goal.
    // Edges that would create a cycle are not added to the MST.

    // Steps for implementing Kruskal's algorithm:
    // 1. Sort all the edges from low weight to high
    // 2. Take the edge with the lowest weight and add it to the spanning tree. If adding the edge created a cycle, then reject this edge.
    // 3. Keep adding edges until we reach all vertices.

    // TC - O(E * logE), SC - O(E), Sorting of edges takes O(E * logE) time


    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }


    static int kruskalsMST(ArrayList<Edge>[] graph, int vertices) {
        List<Edge> edges = new ArrayList<>();

        // O(V + E)
        for (int i = 0; i <= vertices; i++) {
            for (Edge e : graph[i]) {
                edges.add(new Edge(e.src, e.dest, e.weight));
            }
        }

        DisjointSet ds = new DisjointSet(vertices);

        // O(E * logE)
        Collections.sort(edges);
        int mstWt = 0;
        // E * 4 * alpha * 2
        for (Edge e : edges) {
            int a = ds.findUltimateParent(e.src);
            int b = ds.findUltimateParent(e.dest);
            if (a != b) {
                mstWt += e.weight;
                ds.unionBySize(e.src, e.dest);
            }
        }

        return mstWt;
    }


    static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }


    public static void main(String[] args) {
        int vertices = 6;
//        int[][] edges = {{1, 2, 2}, {1, 4, 1}, {1, 5, 4}, {2, 3, 3}, {2, 4, 3}, {2, 6, 7}, {3, 4, 5}, {3, 6, 8}, {4, 5, 9}};
        int[][] edges = {{0, 1, 10}, {0, 2, 6}, {0, 3, 5}, {1, 3, 15}, {2, 3, 4}};

        ArrayList<Edge>[] graph = new ArrayList[vertices + 1];
        for (int i = 0; i <= vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            addEdge(graph, edges[i][0], edges[i][1], edges[i][2]);
        }

        System.out.println(kruskalsMST(graph, vertices));
    }

}

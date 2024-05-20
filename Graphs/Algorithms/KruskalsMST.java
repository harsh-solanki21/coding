package Graphs.Algorithms;

import java.util.Arrays;

public class KruskalsMST {

    // Kruskal's Algorithm finds MST in an Undirected Graph.
    // It falls under a class of algorithms called Greedy Algorithms that find the local optimum in the hope of finding a global optimum.

    // The MSTs found by Kruskal's algorithm is the collection of edges that connect all vertices with the minimum total edge weight.
    // Kruskal's algorithm start from the edges with the lowest weight and keep adding edges until we reach our goal.
    // Edges that would create a cycle are not added to the MST.

    // Steps for implementing Kruskal's algorithm:
    // 1. Sort all the edges by weight.
    // 2. Take the edge with the lowest weight and add it to the spanning tree,
    //    if adding the edge created a cycle (same ultimate parent), then reject this edge.
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


    static int kruskalsMST(int[][] graph, int vertices) {
        int[] parent = new int[vertices];
        int[] size = new int[vertices];
        Edge[] edges = new Edge[graph.length];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < graph.length; i++) {
            edges[i] = new Edge(graph[i][0], graph[i][1], graph[i][2]);
        }
        Arrays.sort(edges);

        int mstWt = 0;
        for (Edge e : edges) {
            int src = findRoot(parent, e.src);
            int dest = findRoot(parent, e.dest);
            if (src != dest) {
                mstWt += e.weight;
                if (size[src] < size[dest]) {
                    parent[src] = dest;
                    size[dest] += size[src];
                } else {
                    parent[dest] = src;
                    size[src] += size[dest];
                }
            }
        }

        return mstWt;
    }

    private static int findRoot(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findRoot(parent, parent[node]);  // Path compression
        return parent[node];
    }


    public static void main(String[] args) {
//        int vertices = 6;
//        int[][] graph = {{0, 1, 2}, {0, 3, 1}, {0, 4, 4}, {1, 2, 3}, {1, 3, 3}, {1, 5, 7}, {2, 3, 5}, {2, 5, 8}, {3, 4, 9}};

        int vertices = 4;
        int[][] graph = {{0, 1, 10}, {0, 2, 6}, {0, 3, 5}, {1, 3, 15}, {2, 3, 4}};

        System.out.println(kruskalsMST(graph, vertices));
    }

}

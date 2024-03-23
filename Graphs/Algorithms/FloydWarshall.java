package Graphs.Algorithms;

import java.util.Arrays;

public class FloydWarshall {

    // Dijkstra and Bellman-Ford are single source shortest path algorithms,
    // Floyd-Warshall is All Pairs Shortest Path Algorithm

    // It works for both the directed and undirected weighted graphs with both positive and negative edge weights.
    // But, it does not work for the graphs with negative cycles (where the sum of the edges in a cycle is negative).
    // It follows Dynamic Programming approach to check every possible path going via every possible node in order to calculate
    // the shortest distance between every pair of nodes.

    // TC - O(V^3), SC - O(V^2)

    static void floydWarshall(int[][] graph) {
        int n = graph.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }


    public static void main(String[] args) {

        // In the absence of an edge, take INFINITY.
        // For self loop, take 0.
        // If Self loop value goes < 0, Negative Cycle Exists.

        int INF = 9999;
        int[][] graph = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };

        floydWarshall(graph);

        for (int[] i : graph) {
            System.out.println(Arrays.toString(i));
        }
    }

}

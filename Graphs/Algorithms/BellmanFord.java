package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    // Shortest distance from the source to all vertices
    // Bellman ford Algorithm works on both +ve and -ve edge weights
    // We can calculate the shortest distance even though cycle exists
    // It works on both Directed and Undirected Graph.
    // TC - O(V * E)


    // The shortest path between two vertices can have at most N-1 edges, where N is the number of vertices.



    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int[] bellmanFord(ArrayList<Edge>[] graph, int source) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax all edges |vertices| - 1 times
        for (int i = 0; i < graph.length - 1; i++) {
            for (Edge e : graph[i]) {
                int src = e.src;
                int dest = e.dest;
                int weight = e.weight;
                if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                    dist[dest] = dist[src] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                int src = e.src;
                int dest = e.dest;
                int weight = e.weight;
                if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                    System.out.println("Graph contains negative weight cycle");
                    return new int[]{-1};
                }
            }
        }

        return dist;
    }


    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));  // negative cycle exists when weight = -10

        int src = 0;
        System.out.println(Arrays.toString(bellmanFord(graph, src)));
    }

}

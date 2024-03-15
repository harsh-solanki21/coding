package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    // Shortest distance from the source to all vertices
    // Bellman ford Algorithm works on both +ve and -ve edge weights
    // We can calculate the shortest distance even though cycle exists
    // TC - O(V * E)

    // BFA fails when there's a negative weight cycle.
    // Which means, if the total weight of cycle comes out negative then BFA will fail.

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

        for (int i = 0; i < graph.length - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int src = e.src;
                    int dest = e.dest;
                    int weight = e.weight;

                    if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                        dist[dest] = dist[src] + weight;
                    }
                }
            }
        }

        // Detect -ve weight cycle
        for (int j = 0; j < graph.length; j++) {
            for (int k = 0; k < graph[j].size(); k++) {
                Edge e = graph[j].get(k);
                int src = e.src;
                int dest = e.dest;
                int weight = e.weight;

                if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                    System.out.println("Negative weight cycle exists!");
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

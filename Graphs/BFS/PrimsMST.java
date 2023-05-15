package Graphs.BFS;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsMST {

    // Prim's Algorithm - Minimum Spanning Tree
    static class Edge {
        int source;
        int neighbour;
        int weight;

        Edge(int source, int neighbour, int weight) {
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int parent;
        int weight;

        Pair(int vertex, int parent, int weight) {
            this.vertex = vertex;
            this.parent = parent;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }


    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // vertices
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Edges
        graph.get(0).add(new Edge(0, 1, 10));
        graph.get(1).add(new Edge(1, 2, 10));
        graph.get(2).add(new Edge(2, 3, 10));
        graph.get(0).add(new Edge(0, 3, 40));
        graph.get(3).add(new Edge(3, 4, 2));
        graph.get(4).add(new Edge(4, 5, 3));
        graph.get(5).add(new Edge(5, 6, 3));
        graph.get(4).add(new Edge(4, 6, 8));

        // also need to add this because of undirected graph
        graph.get(1).add(new Edge(1, 0, 10));
        graph.get(2).add(new Edge(2, 1, 10));
        graph.get(3).add(new Edge(3, 2, 10));
        graph.get(3).add(new Edge(3, 0, 40));
        graph.get(4).add(new Edge(4, 3, 2));
        graph.get(5).add(new Edge(5, 4, 3));
        graph.get(6).add(new Edge(6, 5, 3));
        graph.get(6).add(new Edge(6, 4, 8));


        // Prim's Algo
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean[] visited = new boolean[vertices];

        while (pq.size() > 0) {
            Pair remove = pq.remove();

            if (visited[remove.vertex]) {
                continue;
            }
            visited[remove.vertex] = true;

            if (remove.parent != -1) {
                System.out.println(remove.vertex + " - " + remove.parent + " @ " + remove.weight);
            }

            for (Edge e : graph.get(remove.vertex)) {
                if (!visited[e.neighbour]) {
                    pq.add(new Pair(e.neighbour, remove.vertex, e.weight));
                }
            }


        }

    }

}

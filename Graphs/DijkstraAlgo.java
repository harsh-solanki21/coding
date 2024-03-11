package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {

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
        String pathSoFar;
        int weightSoFar;

        Pair(int vertex, String pathSoFar, int weightSoFar) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
            this.weightSoFar = weightSoFar;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weightSoFar - o.weightSoFar;
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


        int source = 0;

        // Dijkstra's Algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, source + "", 0));
        boolean[] visited = new boolean[vertices];

        while (pq.size() > 0) {
            Pair remove = pq.remove();

            if (visited[remove.vertex]) {
                continue;
            }
            visited[remove.vertex] = true;
            System.out.println(remove.vertex + " via " + remove.pathSoFar + " @ " + remove.weightSoFar);

            for (Edge e : graph.get(remove.vertex)) {
                if (!visited[e.neighbour]) {
                    pq.add(new Pair(e.neighbour, remove.pathSoFar + e.neighbour, remove.weightSoFar + e.weight));
                }
            }
        }

    }

}

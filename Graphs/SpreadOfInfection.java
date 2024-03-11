package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SpreadOfInfection {

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
        int time;

        Pair(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
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
        graph.get(0).add(new Edge(0, 1));
        graph.get(1).add(new Edge(1, 2));
        graph.get(2).add(new Edge(2, 3));
        graph.get(0).add(new Edge(0, 3));
        graph.get(3).add(new Edge(3, 4));
        graph.get(4).add(new Edge(4, 5));
        graph.get(5).add(new Edge(5, 6));
        graph.get(4).add(new Edge(4, 6));

        // also need to add this because of undirected graph
        graph.get(1).add(new Edge(1, 0));
        graph.get(2).add(new Edge(2, 1));
        graph.get(3).add(new Edge(3, 2));
        graph.get(3).add(new Edge(3, 0));
        graph.get(4).add(new Edge(4, 3));
        graph.get(5).add(new Edge(5, 4));
        graph.get(6).add(new Edge(6, 5));
        graph.get(6).add(new Edge(6, 4));


        // You are given a graph, representing people and their connectivity.
        // You are also given a source person (who got infected) and time t.
        // You are required to find how many people will get infected in time t, if the infection spreads to neighbours of
        // infected person in 1 unit of time.

        int infacted = 6, t = 2;

        // Spread of infection
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(infacted, 1));
        int[] visited = new int[vertices];
        int count = 0;

        while (!q.isEmpty()) {
            Pair remove = q.removeFirst();

            if (visited[remove.vertex] > 0) {
                continue;
            }
            visited[remove.vertex] = remove.time;
            if (remove.time > t) {
                break;
            }
            count++;

            for (Edge e : graph.get(remove.vertex)) {
                if (visited[e.neighbour] == 0) {
                    q.add(new Pair(e.neighbour, remove.time + 1));
                }
            }
        }

        System.out.println(count);
    }

}

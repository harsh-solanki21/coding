package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPathAndCycle {

    static class Edge {
        int source;
        int dest;
        int weight;

        Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }


    // Hamiltonian path and cycle
    static void hamiltonian(ArrayList<ArrayList<Edge>> graph, int source, HashSet<Integer> visited, String ans, int originalSource) {
        if (visited.size() == graph.size() - 1) {
            System.out.print(ans);

            boolean closingEdge = false;
            for (Edge edge : graph.get(source)) {
                if (edge.dest == originalSource) {
                    closingEdge = true;
                    break;
                }
            }

            System.out.println(closingEdge ? " * " : " . ");
            return;
        }

        visited.add(source);
        for (Edge edge : graph.get(source)) {
            if (!visited.contains(edge.dest)) {
                hamiltonian(graph, edge.dest, visited, ans + edge.dest, originalSource);
            }
        }
        visited.remove(source);
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
        graph.get(0).add(new Edge(0, 3, 10));
        graph.get(3).add(new Edge(3, 4, 2));
        graph.get(4).add(new Edge(4, 5, 3));
        graph.get(5).add(new Edge(5, 6, 3));
        graph.get(4).add(new Edge(4, 6, 8));
        graph.get(2).add(new Edge(2, 5, 10));

        // also need to add this because of undirected graph
        graph.get(1).add(new Edge(1, 0, 10));
        graph.get(2).add(new Edge(2, 1, 10));
        graph.get(3).add(new Edge(3, 2, 10));
        graph.get(3).add(new Edge(3, 0, 10));
        graph.get(4).add(new Edge(4, 3, 2));
        graph.get(5).add(new Edge(5, 4, 3));
        graph.get(6).add(new Edge(6, 5, 3));
        graph.get(6).add(new Edge(6, 4, 8));
        graph.get(5).add(new Edge(5, 2, 10));

        int source = 0;
        HashSet<Integer> visited = new HashSet<>();
        hamiltonian(graph, source, visited, source + "", source);

    }

}

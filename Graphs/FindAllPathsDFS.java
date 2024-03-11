package Graphs;

import java.util.ArrayList;

public class FindAllPathsDFS {

    // Find all the paths from 0 to 6 in lexicographical order
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


    // print all paths
    // Find Path
    static void printAllPaths(ArrayList<ArrayList<Edge>> graph, int source, int dest, boolean[] visited, String ans) {
        if (source == dest) {
            System.out.println(ans);
            return;
        }

        visited[source] = true;
        for (Edge edge : graph.get(source)) {
            if (!visited[edge.dest]) {
                printAllPaths(graph, edge.dest, dest, visited, ans + edge.dest);
            }
        }
        visited[source] = false;

    }


    public static void main(String[] args) {
        int vertices = 7, edges = 8;
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
        graph.get(3).add(new Edge(3, 4, 10));
        graph.get(4).add(new Edge(4, 5, 10));
        graph.get(5).add(new Edge(5, 6, 10));
        graph.get(4).add(new Edge(4, 6, 10));

        // also need to add this because of undirected graph
        graph.get(1).add(new Edge(1, 0, 10));
        graph.get(2).add(new Edge(2, 1, 10));
        graph.get(3).add(new Edge(3, 2, 10));
        graph.get(3).add(new Edge(3, 0, 10));
        graph.get(4).add(new Edge(4, 3, 10));
        graph.get(5).add(new Edge(5, 4, 10));
        graph.get(6).add(new Edge(6, 5, 10));
        graph.get(6).add(new Edge(6, 4, 10));

        int source = 0, dest = 6;
        printAllPaths(graph, source, dest, new boolean[vertices], source + "");
    }

}

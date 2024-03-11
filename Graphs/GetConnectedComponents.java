package Graphs;

import java.util.ArrayList;

public class GetConnectedComponents {

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


    static void connectedComponents(ArrayList<ArrayList<Edge>> graph, int source, ArrayList<Integer> result, boolean[] visited) {
        visited[source] = true;
        result.add(source);
        for (Edge edge : graph.get(source)) {
            if (!visited[edge.dest]) {
                connectedComponents(graph, edge.dest, result, visited);
            }
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
        graph.get(2).add(new Edge(2, 3, 10));
        graph.get(4).add(new Edge(4, 5, 10));
        graph.get(4).add(new Edge(4, 6, 10));
        graph.get(5).add(new Edge(5, 6, 2));

        // also need to add this because of undirected graph
        graph.get(1).add(new Edge(1, 0, 10));
        graph.get(3).add(new Edge(3, 2, 10));
        graph.get(5).add(new Edge(5, 4, 10));
        graph.get(6).add(new Edge(6, 4, 10));
        graph.get(6).add(new Edge(6, 5, 2));


        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                connectedComponents(graph, i, component, visited);
                ans.add(component);
            }
        }

        System.out.println(ans);

        // Solution of Is Graph connected or not solution
        System.out.println(ans.size() == 1);
        // if size is 1 then all the vertices are connected, so the graph is connected

    }

}

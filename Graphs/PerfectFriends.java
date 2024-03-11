package Graphs;

import java.util.ArrayList;

public class PerfectFriends {

    static class Edge {
        int source;
        int neighbour;

        Edge(int vertex, int neighbour) {
            this.source = vertex;
            this.neighbour = neighbour;
        }
    }


    // Perfect friends
    static void connectedComponents(ArrayList<ArrayList<Edge>> graph, int source, ArrayList<Integer> result, boolean[] visited) {
        visited[source] = true;
        result.add(source);
        for (Edge edge : graph.get(source)) {
            if (!visited[edge.neighbour]) {
                connectedComponents(graph, edge.neighbour, result, visited);
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
        graph.get(0).add(new Edge(0, 1));
        graph.get(2).add(new Edge(2, 3));
        graph.get(4).add(new Edge(4, 5));
        graph.get(4).add(new Edge(4, 6));
        graph.get(5).add(new Edge(5, 6));

        // also need to add this because of undirected graph
        graph.get(1).add(new Edge(1, 0));
        graph.get(3).add(new Edge(3, 2));
        graph.get(5).add(new Edge(5, 4));
        graph.get(6).add(new Edge(6, 4));
        graph.get(6).add(new Edge(6, 5));


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

        int pairs = 0;
        for (int i = 0; i < ans.size(); i++) {
            for (int j = i + 1; j < ans.size(); j++) {
                int count = ans.get(i).size() * ans.get(j).size();
                pairs += count;
            }
        }

        System.out.println(pairs);

    }


}

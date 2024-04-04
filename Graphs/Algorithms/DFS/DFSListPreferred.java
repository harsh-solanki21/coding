package Graphs.Algorithms.DFS;

import java.util.ArrayList;

public class DFSListPreferred {

    static class Edge {
        int source, destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }


    // TC - O(V + E)
    static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int current) {
        System.out.print(current + " ");
        visited[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (!visited[e.destination]) {
                dfs(graph, visited, e.destination);
            }
        }
    }


    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }


    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        /*
              0 --- 1
              |  /  |     4 --- 5    6
              3 --- 2
         */
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

}

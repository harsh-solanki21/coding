package Graphs.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSListPreferred {

    static class Edge {
        int source, destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }


    // TC - O(V + E)
    static void bfs(ArrayList<Edge>[] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            if (!visited[vertex]) {
                System.out.print(vertex + " ");
                visited[vertex] = true;

                for (int i = 0; i < graph[vertex].size(); i++) {
                    Edge e = graph[vertex].get(i);
                    queue.add(e.destination);
                }
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
                bfs(graph, visited, i);
            }
        }
    }
    
}

package Graphs.Algorithms.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSListPreferred {

    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }


    // TC - O(V + E)
    static ArrayList<Integer> bfs(ArrayList<Edge>[] graph, int vertices) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                bfsTraversal(graph, visited, ans, i);
            }
        }
        return ans;
    }

    private static void bfsTraversal(ArrayList<Edge>[] graph, boolean[] visited, ArrayList<Integer> ans, int source) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            ans.add(vertex);

            for (Edge e : graph[vertex]) {
                if (!visited[e.dest]) {
                    q.offer(e.dest);
                    visited[e.dest] = true;
                }
            }
        }
    }


    private static void addEdge(ArrayList<Edge>[] graph, int u, int v) {
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));
    }


    public static void main(String[] args) {
        /*
              0 --- 1
              |  /  |     4 --- 5    6
              3 --- 2
         */
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 4, 5);

        System.out.println(bfs(graph, vertices));
    }

}

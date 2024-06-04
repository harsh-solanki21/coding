package Graphs.Algorithms.DFS;

import java.util.ArrayList;

public class DFSListPreferred {

    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }


    // TC - O(V + E)
    static ArrayList<Integer> dfs(ArrayList<Edge>[] graph, int vertices) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfsTraversal(graph, visited, ans, i);
            }
        }
        return ans;
    }

    private static void dfsTraversal(ArrayList<Edge>[] graph, boolean[] visited, ArrayList<Integer> ans, int node) {
        visited[node] = true;
        ans.add(node);

        for (Edge e : graph[node]) {
            if (!visited[e.dest]) {
                dfsTraversal(graph, visited, ans, e.dest);
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

        System.out.println(dfs(graph, vertices));
    }

}

package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Kosarajus {


    // Strongly Connected Component
    // A strongly connected component is the component of a directed graph that has a path from every vertex to every other vertex in that component.
    // It can only be used in a directed graph.

    // Kosarju’s Algorithm is a DFS based algorithm, in which we perform the DFS twice.
    // Steps:
    // 1. Perform DFS and get nodes in stack (Topological Sort)
    // 2. Reverse/Transpose the graph
    // 3. Perform DFS according to stack node on the reversed graph

    // TC - O(V + E)


    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }


    static List<List<Integer>> kosarajuAlgo(ArrayList<Edge>[] graph, int vertices) {
        List<List<Integer>> ans = new ArrayList<>();

        // Step 1 - O(V + E)
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topoSort(graph, visited, st, i);
            }
        }

        // Step 2 - O(V + E)
        ArrayList<Edge>[] transpose = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < vertices; i++) {
            for (Edge e : graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3 - O(V + E)
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!visited[node]) {
                scc++;
                List<Integer> result = new ArrayList<>();
                dfs(transpose, visited, node, result);
                ans.add(result);
            }
        }

        System.out.println(scc);
        return ans;
    }

    private static void topoSort(ArrayList<Edge>[] graph, boolean[] visited, Stack<Integer> st, int node) {
        visited[node] = true;
        for (Edge e : graph[node]) {
            if (!visited[e.dest]) {
                topoSort(graph, visited, st, e.dest);
            }
        }
        st.push(node);
    }

    private static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int node, List<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (Edge e : graph[node]) {
            if (!visited[e.dest]) {
                dfs(graph, visited, e.dest, result);
            }
        }
    }


    public static void main(String[] args) {

//                  4                   8  →  9
//               ↙     ↖                ↑
//             5          3  ←  1   →   2
//           ↙   ↘     ↗          ↖    ↙
//         7        6                0

        int vertices = 10;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 8));

        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(5, 7));

        graph[6].add(new Edge(6, 3));

        graph[8].add(new Edge(8, 9));

        System.out.println(kosarajuAlgo(graph, vertices));

    }

}

package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort {

    // Topological Sort - Topological sort is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v in the order.
    // Topological sorting is used only for DAGs(Directed Acyclic Graphs), (not for non-DAGs)


    static int[] topologicalSort(ArrayList<ArrayList<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(graph, visited, st, i);
            }
        }

        int[] ans = new int[vertices];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }

        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> st, int node) {
        visited[node] = true;

        for (int i : graph.get(node)) {
            if (!visited[i]) {
                dfs(graph, visited, st, i);
            }
        }

        st.push(node);
    }


    public static void main(String[] args) {

//        0 -> 3 <- 4 -> 6
//        ↓    ↑    ↓   ↑
//        1 -> 2      5

        int vertices = 7;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(3);

        graph.get(1).add(2);

        graph.get(2).add(3);

        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(4).add(6);

        graph.get(5).add(6);

        System.out.println(Arrays.toString(topologicalSort(graph, vertices)));

    }

}

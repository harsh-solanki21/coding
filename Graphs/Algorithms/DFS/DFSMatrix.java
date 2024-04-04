package Graphs.Algorithms.DFS;

import java.util.ArrayList;

public class DFSMatrix {

    private static void dfsTraversal(int[][] graph, boolean[] visited, ArrayList<Integer> ans, int start) {
        visited[start] = true;
        ans.add(start);

        for (int i = 0; i < graph[start].length; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                dfsTraversal(graph, visited, ans, i);
            }
        }
    }

    static ArrayList<Integer> dfs(int[][] graph, int vertices, int start) {
        boolean[] visited = new boolean[vertices];
        visited[0] = true;
        ArrayList<Integer> ans = new ArrayList<>();
        dfsTraversal(graph, visited, ans, start);
        return ans;
    }

    public static void main(String[] args) {
        // Time Complexity: O(N * N)
        // Auxiliary Space: O(N)
        int[][] graph = {{0, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}};
        int vertices = 5;
        int start = 0;
        System.out.println(dfs(graph, vertices, start));
    }

}

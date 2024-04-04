package Graphs.Algorithms.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFSMatrix {

    static ArrayList<Integer> bfs(int[][] graph, int vertices, int source) {
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int node = q.remove();
            ans.add(node);
            for (int i = 0; i < vertices; i++) {
                if (!visited[i] && graph[node][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Time Complexity: O(N * N)
        // Auxiliary Space: O(N)
        int[][] graph = {{0, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}};
        int vertices = 5;
        int source = 0;
        System.out.println(bfs(graph, vertices, source));
    }

}

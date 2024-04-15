package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionDirected {


    // DFS
    static boolean isCyclicDFS(ArrayList<ArrayList<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        boolean[] path = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, path, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] path, int node) {
        visited[node] = true;
        path[node] = true;

        for (int i : graph.get(node)) {
            if (!visited[i]) {
                if (dfs(graph, visited, path, i)) {
                    return true;
                }
            } else if (path[i]) {
                return true;
            }
        }

        path[node] = false;
        return false;
    }


    // BFS - Topological Sort (Kahn's Algorithm)
    static boolean isCyclicBFS(ArrayList<ArrayList<Integer>> graph, int vertices) {
        int[] indegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j : graph.get(i)) {
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int j : graph.get(node)) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    q.offer(j);
                }
            }
        }

        return count != vertices;  // means there's a cycle
    }


    public static void main(String[] args) {

//        0 -> 1 -> 2 -> 6
//             ↓    ↓   ↑
//             3      7
//          ↓    ↑
//          4 -> 5

        int vertices = 8;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);

        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(6);
        graph.get(2).add(7);

        graph.get(3).add(4);

        graph.get(4).add(5);

        graph.get(5).add(3);

        graph.get(7).add(6);

        System.out.println(isCyclicDFS(graph, vertices));
        System.out.println(isCyclicBFS(graph, vertices));
    }

}

package Graphs.DFS;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeState {

    static List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] unsafe = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (unsafe[i] == 0) {
                visited[i] = true;
                dfs(i, visited, graph, unsafe);
                visited[i] = false;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < unsafe.length; i++) {
            if (unsafe[i] == 1) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean dfs(int node, boolean[] visited, int[][] graph, int[] unsafe) {
        boolean isSafe = true;

        for (int neighbor : graph[node]) {
            if (visited[neighbor] || unsafe[neighbor] == 2) {
                isSafe = false;
                break;
            }

            if (unsafe[neighbor] == 1) {
                continue;
            }

            visited[neighbor] = true;
            if (!dfs(neighbor, visited, graph, unsafe)) {
                isSafe = false;
            }
            visited[neighbor] = false;
        }

        unsafe[node] = isSafe ? 1 : 2;
        return isSafe;
    }


    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }

}

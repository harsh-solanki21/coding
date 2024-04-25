package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeState {

    // Every node who is a part of a cycle, cannot be a safe node.
    // So, every node who is not part of a cycle, is the answer.

    // 1. with given ArrayList<ArrayList<Integer>> (GFG)
    static ArrayList<Integer> eventualSafeNode(ArrayList<ArrayList<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        boolean[] pathVisited = new boolean[vertices];
        boolean[] check = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(graph, visited, pathVisited, check, i);
            }
        }

        ArrayList<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (check[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] pathVisited, boolean[] check, int node) {
        visited[node] = true;
        pathVisited[node] = true;
        check[node] = false;

        for (int i : graph.get(node)) {
            if (!visited[i]) {
                if (dfs(graph, visited, pathVisited, check, i)) {
                    return true;
                }
            } else if (pathVisited[i]) {
                return true;
            }
        }

        pathVisited[node] = false;
        check[node] = true;
        return false;
    }


    // 2. with given int[][] (Leetcode)
    static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[graph.length];
        // 0 = not visited
        // 1 = visited and safe
        //-1 = visited and not safe
        // 2 = currently visiting

        for (int i = 0; i < graph.length; i++) {
            boolean check = dfs(graph, visited, i);
            if (check) {
                ans.add(i);
            }
        }

        return ans;
    }

    private static boolean dfs(int[][] graph, int[] visited, int node) {
        if (visited[node] == 2 || visited[node] == -1) {
            return false;
        }
        if (visited[node] == 1) {
            return true;
        }

        visited[node] = 2;
        for (int i : graph[node]) {
            boolean check = dfs(graph, visited, i);
            if (!check) {
                visited[node] = -1;
                return false;
            }
        }
        visited[node] = 1;

        return true;
    }



    // BFS - Kahn's Algorithm (Topological Sort)
    static List<Integer> eventualSafeNodesBFS(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                // can't traverse the graph with terminal nodes, So invert all the indegrees
                adj.get(j).add(i);  // Inverting the indegrees
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }



    public static void main(String[] args) {
        // 1. ArrayList<ArrayList<Integer>>

//            0 -> 1 -> 2 -> 3 -> 5
//                 ↑         ↓    ↓
//                 8         4 -> 6 -> 7
//               ↓   ↑
//        11 -> 9 -> 10

        int vertices = 12;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);

        graph.get(1).add(2);

        graph.get(2).add(3);

        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(6);

        graph.get(5).add(6);

        graph.get(6).add(7);

        graph.get(8).add(1);
        graph.get(8).add(9);

        graph.get(9).add(10);

        graph.get(10).add(8);

        graph.get(11).add(9);

        System.out.println(eventualSafeNode(graph, vertices));


        // 2. int[][]
//        int[][] graph2 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        int[][] graph2 = {{1}, {2}, {3}, {4, 5}, {6}, {6}, {7}, {}, {1, 9}, {10}, {8}, {9}};
        System.out.println(eventualSafeNodes(graph2));

        System.out.println(eventualSafeNodesBFS(graph2));
    }

}

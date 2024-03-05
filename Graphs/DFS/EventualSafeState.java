package Graphs.DFS;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeState {

    // 1. with given ArrayList<ArrayList<Integer>>
    static ArrayList<Integer> eventualSafeNode(ArrayList<ArrayList<Integer>> graph, int vertices) {
        int[] visited = new int[vertices];
        int[] pathVisited = new int[vertices];
        int[] check = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            if (visited[i] == 0) {
                dfs(graph, visited, pathVisited, check, i);
            }
        }

        ArrayList<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (check[i] == 1) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int[] pathVisited, int[] check, int node) {
        visited[node] = 1;
        pathVisited[node] = 1;
        check[node] = 0;

        for (int i : graph.get(node)) {
            if (visited[i] == 0) {
                if (dfs(graph, visited, pathVisited, check, i)) {
                    return true;
                }
            } else if (pathVisited[i] == 1) {
                return true;
            }
        }

        check[node] = 1;
        pathVisited[node] = 0;
        return false;
    }


    // 2. with given int[][]
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
        // 1. ArrayList<ArrayList<Integer>>

//      0 -> 1 -> 2 -> 3 -> 5
//           ↑         ↓    ↓
//           8         4 -> 6 -> 7
//         ↓   ↑
//  11 -> 9 -> 10

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
    }

}

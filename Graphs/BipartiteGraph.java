package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    // BFS
    static boolean isBipartiteBFS(ArrayList<ArrayList<Integer>> graph, int vertices) {
        int[] color = new int[vertices];
        Arrays.fill(color, -1);

        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1) {
                if (!check(graph, color, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean check(ArrayList<ArrayList<Integer>> graph, int[] color, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i : graph.get(node)) {
                if (color[i] == -1) {
                    color[i] = 1 - color[node];
                    q.offer(i);
                } else {
                    if (color[i] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    // DFS
    static boolean isBipartiteDFS(ArrayList<ArrayList<Integer>> graph, int vertices) {
        int[] color = new int[vertices];
        Arrays.fill(color, -1);

        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, color, i, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, int[] color, int node, int col) {
        color[node] = col;

        for (int i : graph.get(node)) {
            if (color[i] == -1) {
                if (!dfs(graph, color, i, 1 - col)) {
                    return false;
                }
            } else if (color[i] == col) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

//  True Case     2               False Case     2
//              /   \                         /     \
//        0 -- 1      4 -- 5            0 -- 1        5 -- 6
//              \   /                         \      /
//                3                            3 -- 4

        int vertices = 7;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);

        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(1);
        graph.get(2).add(5);

        graph.get(3).add(1);
        graph.get(3).add(4);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(2);
        graph.get(5).add(4);
        graph.get(5).add(6);

        graph.get(6).add(5);

//        System.out.println(isBipartiteBFS(graph, vertices));
        System.out.println(isBipartiteDFS(graph, vertices));
    }

}

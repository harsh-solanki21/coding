package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    // Graphs with no cycle are always Bipartite.
    // Graphs with even cycle length are Bipartite.
    // Graphs with odd cycle length are Not Bipartite.


    // 1. When Graph is given as ArrayList<ArrayList<Integer>>
    // BFS
    static boolean isBipartiteBFS(ArrayList<ArrayList<Integer>> graph, int vertices) {
        int[] color = new int[vertices];
        Arrays.fill(color, -1);

        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, color, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> graph, int[] color, int start) {
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


    // 2. When Graph is given as int[][]
    // BFS
    static boolean isBipartite1(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!bfsCheck(graph, colors, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfsCheck(int[][] graph, int[] colors, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        colors[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            int currentColor = colors[node];

            for (int i : graph[node]) {
                if (colors[i] == -1) {
                    colors[i] = (currentColor == 1) ? 0 : 1;
                    q.offer(i);
                } else {
                    if (colors[i] == currentColor) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    // DFS 1
    static boolean isBipartite2(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !dfsCheck(graph, colors, i, true)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfsCheck(int[][] graph, int[] colors, int src, boolean red) {
        if (red) {
            colors[src] = 1;
        } else {
            colors[src] = 2;
        }

        for (int i : graph[src]) {
            if (colors[i] == (red ? 1 : 2) || colors[i] == 0 && !dfsCheck(graph, colors, i, !red)) {
                return false;
            }
        }

        return true;
    }


    // DFS 2
    static boolean isBipartiteDFS(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!dfs2(graph, color, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean dfs2(int[][] graph, int[] color, int src) {
        for (int i : graph[src]) {
            if (color[i] == -1) {
                color[i] = 1 - color[src];
                if (!dfs2(graph, color, i)) {
                    return false;
                }
            } else if (color[i] == color[src]) {
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {

        // 1. When Graph is given as ArrayList<ArrayList<Integer>>

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
//        System.out.println(isBipartiteDFS(graph, vertices));


        // 2. When Graph is given as int[][]

//        False Case            True Case
//        0 --- 1               0 -- 1
//        |  \  |               |    |
//        3 --- 2               3 -- 2

        int[][] graph2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite1(graph2));
        System.out.println(isBipartite2(graph2));

    }

}

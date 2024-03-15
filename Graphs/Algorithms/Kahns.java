package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Kahns {

    // Kahn’s algorithm for Topological Sorting

    static int[] topologicalSort(ArrayList<ArrayList<Integer>> graph, int vertices) {
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

        int[] ans = new int[vertices];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[i++] = node;

            for (int j : graph.get(node)) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    q.offer(j);
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {

//        5 -> 0 <- 4
//        ↓         ↓
//        2 -> 3 -> 1

        int vertices = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(2).add(3);

        graph.get(3).add(1);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(5).add(0);
        graph.get(5).add(2);

        System.out.println(Arrays.toString(topologicalSort(graph, vertices)));

    }

}

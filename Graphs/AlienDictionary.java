package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

    // Given a sorted dictionary of an alien language having N words and k starting alphabets of a standard dictionary.
    // Find the order of characters in the alien language.

    static String findOrder(String[] dict, int n, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    graph.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> topoSort = topologicalSort(graph, k);
        String ans = "";
        for (int i : topoSort) {
            ans += (char) (i + (int) ('a'));
        }

        return ans;
    }

    private static List<Integer> topologicalSort(List<List<Integer>> graph, int k) {
        int[] indegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int j : graph.get(i)) {
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int i : graph.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        return topo;
    }


    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int n = 5, k = 4;

        System.out.println(findOrder(dict, n, k));
    }

}

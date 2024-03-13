package Graphs;

import java.util.*;

public class AlienDictionary {

    // Given a sorted dictionary of an alien language having N words and k starting alphabets of a standard dictionary.
    // Find the order of characters in the alien language.

    // 1. DFS (Preferred)
    static String alienOrder(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Boolean> visit = new HashMap<>();  // false = visited, true = current path
        StringBuilder res = new StringBuilder();

        for (String s : words) {
            for (char c : s.toCharArray()) {
                adj.put(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for (Character c : adj.keySet()) {
            if (dfs(adj, visit, res, c)) {
                return "";
            }
        }

        return res.reverse().toString();
    }

    private static boolean dfs(Map<Character, Set<Character>> adj, Map<Character, Boolean> visit, StringBuilder res, Character c) {
        if (visit.containsKey(c)) {
            return visit.get(c);
        }

        visit.put(c, true);
        for (Character i : adj.get(c)) {
            if (dfs(adj, visit, res, i)) {
                return true;
            }
        }

        visit.put(c, false);
        res.append(c);
        return false;
    }


    // 2. Topological Sort (Kahn's Algorithm)
    static String findOrder(String[] dict, int n, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
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
        StringBuilder ans = new StringBuilder();
        for (int i : topoSort) {
            ans.append((char) (i + (int) ('a')));
        }

        return ans.toString();
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
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};

        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int n = 5, k = 4;

        System.out.println(alienOrder(words));
        System.out.println(findOrder(dict, n, k));
    }

}

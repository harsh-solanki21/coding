package Graphs;

public class NumberOfProvinces {

    // https://leetcode.com/problems/number-of-provinces/
    // Given an undirected graph with V vertices. We say two vertices u and v belong to a single province
    // if there is a path from u to v or v to u. Your task is to find the number of provinces.
    // Note: A province is a group of directly or indirectly connected cities and no other cities outside of group.

    // TC - O(V) + O(V) = O(V)
    // SC - O(V + 2E)

    // DFS
    static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    private static void dfs(int[][] graph, int i, boolean[] visited) {
        for (int j = 0; j < graph[i].length; j++) {
            if (!visited[j] && graph[i][j] != 0) {
                visited[j] = true;
                dfs(graph, j, visited);
            }
        }
    }


    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }

}

package Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    // https://leetcode.com/problems/number-of-islands/
    // https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1

    // DFS
    static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j])
            return;

        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);  // up
        dfs(grid, visited, i - 1, j - 1);  // up-left
        dfs(grid, visited, i, j - 1);  // left
        dfs(grid, visited, i + 1, j - 1);  // left-down
        dfs(grid, visited, i + 1, j);  // down
        dfs(grid, visited, i + 1, j + 1);  // down-right
        dfs(grid, visited, i, j + 1);  // right
        dfs(grid, visited, i - 1, j + 1);  // right-up
    }




    // BFS
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int numOflands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        int[] nums1 = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] nums2 = {0, -1, 0, 1, -1, 1, 1, -1};

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int first = q.peek().first;
            int second = q.peek().second;
            q.remove();

            for (int a = 0; a < 8; a++) {
                int val1 = first + nums1[a];
                int val2 = second + nums2[a];
                if (check(grid, visited, val1, val2)) {
                    q.add(new Pair(val1, val2));
                    visited[val1][val2] = true;
                }
            }
        }

    }

    private static boolean check(char[][] grid, boolean[][] visited, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1' && !visited[i][j];
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
        System.out.println(numOflands(grid));
    }

}

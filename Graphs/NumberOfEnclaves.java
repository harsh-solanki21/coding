package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    // DFS
    static int numEnclavesDFS(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int land = 0;

        for (int i = 0, j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                dfs(grid, visited, i, j);
            }
        }

        for (int i = 0, j = grid[0].length - 1; i < grid.length; i++) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                dfs(grid, visited, i, j);
            }
        }

        for (int i = grid.length - 1, j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                dfs(grid, visited, i, j);
            }
        }

        for (int i = 0, j = 0; i < grid.length; i++) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                dfs(grid, visited, i, j);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    land++;
                }
            }
        }

        return land;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
    }


    // BFS - Results in TLE on Leetcode
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int numEnclavesBFS(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int land = 0;

        for (int i = 0, j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1) {
                q.offer(new Pair(i, j));
                visited[i][j] = true;
            }
        }

        for (int i = 0, j = grid[0].length - 1; i < grid.length; i++) {
            if (grid[i][j] == 1) {
                q.offer(new Pair(i, j));
                visited[i][j] = true;
            }
        }

        for (int i = grid.length - 1, j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1) {
                q.offer(new Pair(i, j));
                visited[i][j] = true;
            }
        }

        for (int i = 0, j = 0; i < grid.length; i++) {
            if (grid[i][j] == 1) {
                q.offer(new Pair(i, j));
                visited[i][j] = true;
            }
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair node = q.poll();
            for (int i = 0; i < 4; i++) {
                int first = node.x + row[i];
                int second = node.y + col[i];
                if (first >= 0 && second >= 0 && first < grid.length && second < grid[0].length) {
                    if (grid[first][second] == 1) {
                        q.offer(new Pair(first, second));
                        visited[first][second] = true;
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    land++;
                }
            }
        }

        return land;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        System.out.println(numEnclavesDFS(grid));
//        System.out.println(numEnclavesBFS(grid));
    }

}

package Graphs.DFS;

import java.util.ArrayList;
import java.util.HashSet;

public class CountDistinctIslands {

    // Given a non-empty 2D array grid of 0's and 1's,
    // an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical).
    // You may assume all four edges of the grid are surrounded by water.
    //
    // Count the number of distinct islands.
    // An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.


    static int countDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        HashSet<ArrayList<String>> hs = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> res = new ArrayList<>();
                    dfs(i, j, grid, visited, res, i, j);
                    hs.add(res);
                    System.out.println(hs);
                }
            }
        }

        return hs.size();
    }

    private static void dfs(int i, int j, int[][] grid, boolean[][] visited, ArrayList<String> res, int row0, int col0) {
        visited[i][j] = true;
        res.add("(" + (i - row0) + ", " + (j - col0) + ")");

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        for (int a = 0; a < 4; a++) {
            int first = i + row[a];
            int second = j + col[a];
            if (first >= 0 && second >= 0 && first < grid.length && second < grid[0].length && !visited[first][second] && grid[first][second] == 1) {
                dfs(first, second, grid, visited, res, row0, col0);
            }
        }
    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        System.out.println(countDistinctIslands(grid));
    }

}

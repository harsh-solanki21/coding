package Graphs;

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
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ArrayList<String> res = new ArrayList<>();
                    dfs(grid, visited, res, i, j, i, j);
                    hs.add(res);
                }
            }
        }

        return hs.size();
    }

    private static void dfs(int[][] grid, boolean[][] visited, ArrayList<String> res, int i, int j, int baseI, int baseJ) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        res.add("(" + (i - baseI) + ", " + (j - baseJ) + ")");
        dfs(grid, visited, res, i - 1, j, baseI, baseJ);
        dfs(grid, visited, res, i + 1, j, baseI, baseJ);
        dfs(grid, visited, res, i, j + 1, baseI, baseJ);
        dfs(grid, visited, res, i, j - 1, baseI, baseJ);
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

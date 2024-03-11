package Graphs;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    // https://leetcode.com/problems/pacific-atlantic-water-flow/

    static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            dfs(0, i, row, col, pacific, heights[0][i], heights);
            dfs(row - 1, i, row, col, atlantic, heights[row - 1][i], heights);
        }
        for (int i = 0; i < row; i++) {
            dfs(i, 0, row, col, pacific, heights[i][0], heights);
            dfs(i, col - 1, row, col, atlantic, heights[i][col - 1], heights);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int i, int j, int row, int col, boolean[][] visited, int prev, int[][] heights) {
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || prev > heights[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(i + 1, j, row, col, visited, heights[i][j], heights);
        dfs(i - 1, j, row, col, visited, heights[i][j], heights);
        dfs(i, j + 1, row, col, visited, heights[i][j], heights);
        dfs(i, j - 1, row, col, visited, heights[i][j], heights);
    }


    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};

        System.out.println(pacificAtlantic(heights));
    }

}

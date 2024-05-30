package Graphs;

import java.util.HashSet;

public class MakingALargeIsland {

    // https://leetcode.com/problems/making-a-large-island/description/

    static int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                for (int ind = 0; ind < 4; ind++) {
                    int newRow = i + row[ind];
                    int newCol = j + col[ind];
                    if (isValid(grid, newRow, newCol, n)) {
                        int u = (i * n) + j;
                        int v = (newRow * n) + newCol;
                        ds.unionBySize(u, v);
                    }
                }
            }
        }

        int largestIsland = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }

                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newRow = i + row[ind];
                    int newCol = j + col[ind];
                    if (isValid(grid, newRow, newCol, n)) {
                        components.add(ds.find(newRow * n + newCol));
                    }
                }

                int sizeTotal = 0;
                for (int parents : components) {
                    sizeTotal += ds.size[parents];
                }
                largestIsland = Math.max(largestIsland, sizeTotal + 1);
            }
        }

        // to handle the scenario when grid is filled with only 1s
        for (int i = 0; i < n * n; i++) {
            largestIsland = Math.max(largestIsland, ds.size[ds.find(i)]);
        }

        return largestIsland;
    }

    private static boolean isValid(int[][] grid, int row, int col, int n) {
        return row >= 0 && col >= 0 && row < n && col < n && grid[row][col] == 1;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0}
        };
        System.out.println(largestIsland(grid));
    }

}

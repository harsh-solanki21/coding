package Backtracking;

public class PathWithMaxGold {

    // https://leetcode.com/problems/path-with-maximum-gold/

    // In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell,
    // 0 if it is empty.
    //
    // Return the maximum amount of gold you can collect under the conditions:
    // 1. Every time you are located in a cell you will collect all the gold in that cell.
    // 2. From your position, you can walk one step to the left, right, up, or down.
    // 3. You can't visit the same cell more than once.
    // 4. Never visit a cell with 0 gold.
    // You can start and stop collecting gold from any position in the grid that has some gold.

    static int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxGold = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    int gold = travelAndCollectGold(grid, visited, i, j, 0);
                    maxGold = Math.max(maxGold, gold);
                }
            }
        }

        return maxGold;
    }

    private static int travelAndCollectGold(int[][] grid, boolean[][] visited, int i, int j, int sum) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return sum;
        }

        sum += grid[i][j];
        visited[i][j] = true;

        int max = 0;

        int rightDown = Math.max(travelAndCollectGold(grid, visited, i, j + 1, sum), travelAndCollectGold(grid, visited, i + 1, j, sum));
        int leftUp = Math.max(travelAndCollectGold(grid, visited, i, j - 1, sum), travelAndCollectGold(grid, visited, i - 1, j, sum));
        int ans = Math.max(rightDown, leftUp);
        max = Math.max(ans, max);

        sum -= grid[i][j];
        visited[i][j] = false;

        return max;
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}};

        System.out.println(getMaximumGold(grid));
    }

}

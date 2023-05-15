package RecursionMedium;

public class MaxAreaOfIsland {

    static int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    count = maxArea(grid, i, j, visited);
                    if (count > maxArea) {
                        maxArea = count;
                    }
                }
                visited[i][j] = true;
            }
        }

        return maxArea;
    }

    private static int maxArea(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int count = 1;
        count += maxArea(grid, row, col + 1, visited);
        count += maxArea(grid, row + 1, col, visited);
        count += maxArea(grid, row, col - 1, visited);
        count += maxArea(grid, row - 1, col, visited);

        return count;
    }


    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid));
    }

}

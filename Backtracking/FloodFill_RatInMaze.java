package Backtracking;

public class FloodFill_RatInMaze {

    // This problem is same as Rat in a Maze problem.
    // 0 is the path where we can walk, 1 is obstacle.
    // Directions where we can go: top, down, left, right
    static void floodFill(int[][] maze, int row, int col, String psf, boolean[][] visited) {  // psf = path so far
        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col]) {
            // order matters here
            // because if the first condition is true in OR then it won't check for other conditions and will return
            return;
        }
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }
        visited[row][col] = true;
        floodFill(maze, row - 1, col, psf + "t", visited);
        floodFill(maze, row, col - 1, psf + "l", visited);
        floodFill(maze, row + 1, col, psf + "d", visited);
        floodFill(maze, row, col + 1, psf + "r", visited);
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        int[][] maze = {{0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        floodFill(maze, 0, 0, "", visited);
    }

}

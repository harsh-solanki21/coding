package Graphs;

public class CountIslands {


    static int countIslands(int[][] nums) {
        boolean[][] visited = new boolean[nums.length][nums[0].length];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 0 && !visited[i][j]) {
                    checkIsland(nums, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    static void checkIsland(int[][] nums, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i > nums.length - 1 || j > nums[0].length - 1 || nums[i][j] == 1 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        checkIsland(nums, i - 1, j, visited);
        checkIsland(nums, i, j + 1, visited);
        checkIsland(nums, i, j - 1, visited);
        checkIsland(nums, i + 1, j, visited);
    }


    public static void main(String[] args) {
        int[][] nums = {{0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}};
        // all the 0's are land and all the 1's are water

        System.out.println(countIslands(nums));
    }

}

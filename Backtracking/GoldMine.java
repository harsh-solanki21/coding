package Backtracking;

import java.util.ArrayList;

public class GoldMine {

    // Return maximum gold you can find from a mine
    //
    // Return the maximum amount of gold you can collect under the conditions:
    // 1. Every time you are located in a cell you will collect all the gold in that cell.
    // 2. From your position, you can walk one step to the left, right, up, or down.
    // 3. You can't visit the same cell more than once.
    // 4. Never visit a cell with 0 gold.

    static int getMaxGold(int[][] nums) {
        boolean[][] visited = new boolean[nums.length][nums[0].length];
        int maxGold = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] != 0 && !visited[i][j]) {
                    ArrayList<Integer> gold = new ArrayList<>();
                    travelAndCollectGold(nums, visited, i, j, gold);

                    int sum = 0;
                    for (int num : gold) {
                        sum += num;
                    }
                    maxGold = Math.max(maxGold, sum);
                }
            }
        }

        return maxGold;
    }

    private static void travelAndCollectGold(int[][] nums, boolean[][] visited, int i, int j, ArrayList<Integer> gold) {
        if (i < 0 || j < 0 || i == nums.length || j == nums[0].length || nums[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        gold.add(nums[i][j]);
        travelAndCollectGold(nums, visited, i, j + 1, gold);
        travelAndCollectGold(nums, visited, i + 1, j, gold);
        travelAndCollectGold(nums, visited, i, j - 1, gold);
        travelAndCollectGold(nums, visited, i - 1, j, gold);
    }


    public static void main(String[] args) {
        int[][] nums = {{10, 0, 100, 200, 0, 8, 0},
                {20, 0, 0, 0, 0, 6, 0},
                {30, 0, 0, 9, 12, 3, 4},
                {40, 0, 2, 5, 8, 3, 11},
                {0, 0, 0, 0, 0, 9, 0},
                {5, 6, 7, 0, 7, 4, 2},
                {8, 9, 10, 0, 1, 10, 8}};

        System.out.println(getMaxGold(nums));
    }

}

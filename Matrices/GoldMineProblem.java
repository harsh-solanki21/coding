package Matrices;

public class GoldMineProblem {

//    Given a gold mine called M of (n x m) dimensions.
//    Each field in this mine contains a positive integer which is the amount of gold in tons.
//    Initially the miner can start from any row in the first column.
//    From a given cell, the miner can move:

//    1. to the cell diagonally up towards the right
//    2. to the right
//    3. to the cell diagonally down towards the right

//    Find out maximum amount of gold which he can collect until he can no longer move.

    static int maxGold(int n, int m, int[][] nums) {
        int ans = 0;
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int a = i > 0 ? nums[i - 1][j - 1] : 0;
                int b = nums[i][j - 1];
                int c = i < n - 1 ? nums[i + 1][j - 1] : 0;

                nums[i][j] += Math.max(a, Math.max(b, c));
                ans = Math.max(ans, nums[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] nums = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };
        System.out.println(maxGold(n, m, nums));
    }

}

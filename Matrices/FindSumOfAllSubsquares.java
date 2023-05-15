package Matrices;

import java.util.Arrays;

public class FindSumOfAllSubsquares {

    // TC - O(k^2 * n^2), SC - O(n^2)
    static int[][] subsquareSum(int[][] nums, int k) {
        int n = nums.length - k + 1;
        int[][] ans = new int[n][n];
        int idxI = 0, idxJ = 0;

        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < nums.length - k + 1; j++) {
                int sum = 0;
                for (int p = i; p < k + i; p++) {
                    for (int q = j; q < k + j; q++) {
                        sum += nums[p][q];
                    }
                }

                ans[idxI][idxJ++] = sum;
            }

            idxI++;
            idxJ = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}};
        int k = 3;

        int[][] ans = subsquareSum(nums, k);
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }
    }

}

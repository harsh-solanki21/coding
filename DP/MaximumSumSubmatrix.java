package DP;

public class MaximumSumSubmatrix {

    // Maximum Sum SubMatrix | Maximum Sum Rectangle | Extended Kadane's Algorithm | Dynamic Programming
    static int maxSumSubmatrix(int[][] nums, int row, int col) {
        int[] sum = new int[row];
        int maxSum = Integer.MIN_VALUE;

        for (int cStart = 0; cStart < col; cStart++) {
            for (int cEnd = cStart; cEnd < col; cEnd++) {
                for (int i = 0; i < row; i++) {
                    sum[i] += nums[i][cEnd];
                }
                int currMaxSum = kadens(sum);
                maxSum = Math.max(maxSum, currMaxSum);
            }
        }

        return maxSum;
    }

    private static int kadens(int[] sum) {
        int maxSoFar = Integer.MIN_VALUE, maxEndsHere = 0;

        for (int i = 0; i < sum.length; i++) {
            maxEndsHere += sum[i];
            if (maxSoFar < maxEndsHere) {
                maxSoFar = maxEndsHere;
            }
            if (maxEndsHere < 0) {
                maxEndsHere = 0;
            }
        }

        return maxSoFar;
    }


    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, -2, 1},
                {3, 8, 9, 1, 3},
                {-4, -1, 1, 7, -6},
                {-2, -3, 8, 1, -1}
        };
        System.out.println(maxSumSubmatrix(nums, nums.length, nums[0].length));
    }

}

package DP;

public class FrogJump {

    // Greedy approach won't work

    // Recursion
    // TC - O(2^n), SC - O(n)
    static int frogJump(int[] heights, int i) {
        if (i == 0) {
            return 0;
        }

        int left = frogJump(heights, i - 1) + Math.abs(heights[i] - heights[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) {
            right = frogJump(heights, i - 2) + Math.abs(heights[i] - heights[i - 2]);
        }
        return Math.min(left, right);
    }


    // Memoization
    // TC - O(n), SC - O(n)
    static int frogJumpMemoize(int[] heights, int[] dp, int i) {
        if (i == 0) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }

        int left = frogJumpMemoize(heights, dp, i - 1) + Math.abs(heights[i] - heights[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) {
            right = frogJumpMemoize(heights, dp, i - 2) + Math.abs(heights[i] - heights[i - 2]);
        }

        dp[i] = Math.min(left, right);
        return dp[i];
    }


    // Tabulation
    // TC - O(n), SC - O(n)
    static int frogJumpTabulation(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }


    // Space optimization
    // TC - O(n), SC - O(1)
    static int frogJumpSpace(int[] heights) {
        int first = 0, second = 0;
        for (int i = 1; i < heights.length; i++) {
            int left = first + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = second + Math.abs(heights[i] - heights[i - 2]);
            }
            int curr = Math.min(left, right);
            second = first;
            first = curr;
        }
        return first;
    }


    public static void main(String[] args) {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};  // 7
        System.out.println(frogJump(heights, heights.length - 1));
        System.out.println(frogJumpMemoize(heights, new int[heights.length + 1], heights.length - 1));
        System.out.println(frogJumpTabulation(heights));
        System.out.println(frogJumpSpace(heights));
    }

}

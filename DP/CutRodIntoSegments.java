package DP;

import java.util.Arrays;

public class CutRodIntoSegments {

    // You are given an integer N denoting the length of the rod. You need to determine the maximum number of segments
    // you can make of this rod provided that each segment should be of the length X, Y or Z.

    // Recursive
    static int cutSegments(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int a = cutSegments(n - x, x, y, z) + 1;
        int b = cutSegments(n - y, x, y, z) + 1;
        int c = cutSegments(n - z, x, y, z) + 1;
        int ans = Math.max(a, Math.max(b, c));

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }


    // Memoized
    static int cutSegmentsMemoize(int n, int x, int y, int z, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int a = cutSegmentsMemoize(n - x, x, y, z, dp) + 1;
        int b = cutSegmentsMemoize(n - y, x, y, z, dp) + 1;
        int c = cutSegmentsMemoize(n - z, x, y, z, dp) + 1;
        int ans = Math.max(a, Math.max(b, c));

        dp[n] = ans;
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }


    // Tabulation
    static int cutSegmentsTabulation(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i - x >= 0 && dp[i - x] != -1) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            if (i - y >= 0 && dp[i - y] != -1) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            if (i - z >= 0 && dp[i - z] != -1) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }

        return dp[n] == -1 ? 0 : dp[n];
    }


    public static void main(String[] args) {
        int n = 7, x = 5, y = 2, z = 2;
        System.out.println(cutSegments(n, x, y, z));
        System.out.println(cutSegmentsMemoize(n, x, y, z, new int[n + 1]));
        System.out.println(cutSegmentsTabulation(n, x, y, z));
    }

}

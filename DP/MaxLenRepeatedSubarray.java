package DP;

public class MaxLenRepeatedSubarray {

    // https://leetcode.com/problems/maximum-length-of-repeated-subarray/

    // Recursive Solution
    static int findLengthRecursive(int[] nums1, int[] nums2) {
        return helper(nums1, nums2, nums1.length - 1, nums2.length - 1, 0);
    }

    private static int helper(int[] nums1, int[] nums2, int i, int j, int cnt) {
        if (i < 0 || j < 0) {
            return cnt;
        }

        if (nums1[i] == nums2[j]) {
            cnt = helper(nums1, nums2, i - 1, j - 1, cnt + 1);
        }

        return Math.max(cnt, Math.max(helper(nums1, nums2, i - 1, j, 0), helper(nums1, nums2, i, j - 1, 0)));
    }


    // Tabulation
    // TC - O(m * n), SC - O(m * n)
    static int findLengthTabulation(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, ans = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }


    // Space Optimization
    // TC - O(m * n), SC - O(2 * n)
    static int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, ans = 0;
        int[][] dp = new int[2][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
                    ans = Math.max(ans, dp[i % 2][j]);
                } else {
                    dp[i % 2][j] = 0;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(findLength(nums1, nums2));
    }

}

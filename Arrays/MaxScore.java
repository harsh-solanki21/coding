package Arrays;

public class MaxScore {

    // https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

    static int N, M;

    static int maximumScore(int[] nums, int[] multipliers) {
        N = nums.length;
        M = multipliers.length;
        return helper(nums, multipliers, 0, 0, new Integer[M][M]);
    }

    private static int helper(int[] nums, int[] multipliers, int left, int index, Integer[][] dp) {
        int right = N - 1 - (index - left);
        if (index == M) {
            return 0;
        }

        if (dp[left][index] != null) {
            return dp[left][index];
        }

        int res = Math.max(nums[left] * multipliers[index] + helper(nums, multipliers, left + 1, index + 1, dp),
                nums[right] * multipliers[index] + helper(nums, multipliers, left, index + 1, dp));

        dp[left][index] = res;
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-5, -3, -3, -2, 7, 1};
        int[] multipliers = {-10, -5, 3, 4, 6};

        System.out.println(maximumScore(nums, multipliers));
    }

}

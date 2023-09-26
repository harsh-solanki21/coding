package DP;

public class CountDerangements {

    // A Derangement is a permutation of ‘N’ elements, such that no element appears in its original position.
    // For example, an instance of derangement of {0, 1, 2, 3} is {2, 3, 1, 0},
    // because 2 present at index 0 is not at its initial position which is 2 and similarly for other elements of the sequence.
    // Given a number ‘N’, find the total number of derangements possible of a set of 'N’ elements.

    // Recursive
    static int countDerangements(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int ans = (n - 1) * (countDerangements(n - 1) + countDerangements(n - 2));

        return ans;
    }


    // Memoize (Top-Down)
    static int countDerangementsMemoize(int n, int[] dp) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int ans = (n - 1) * (countDerangementsMemoize(n - 1, dp) + countDerangementsMemoize(n - 2, dp));

        dp[n] = ans;
        return ans;
    }


    // Tabulation (Bottom-Up)
    static int countDerangementsTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            int sum = dp[i - 1] + dp[i - 2];
            int ans = (i - 1) * sum;
            dp[i] = ans;
        }

        return dp[n];
    }


    // Space Optimized
    static int countDerangementsSpaceOptimize(int n) {
        int prev2 = 0;
        int prev1 = 1;

        for (int i = 3; i <= n; i++) {
            int sum = prev1 + prev2;
            int ans = (i - 1) * sum;
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countDerangements(n));  // 7 -> 0,1,2,..,6
        System.out.println(countDerangementsMemoize(n, new int[n + 1]));
        System.out.println(countDerangementsTabulation(n));
        System.out.println(countDerangementsSpaceOptimize(n));
    }

}

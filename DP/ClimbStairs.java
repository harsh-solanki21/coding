package DP;

public class ClimbStairs {

    // 2 Approaches in DP:
    // 1. top-Down  -> Recursion + Memoization  (Map / Array)
    // 2. Bottom-Up -> Tabulation
    // then Space optimization

    // MEMOIZATION
    static int countPaths(int n, int[] cp) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        if (cp[n] > 0) {
            return cp[n];
        }

        int path1 = countPaths(n - 1, cp);
        int path2 = countPaths(n - 2, cp);
        int path3 = countPaths(n - 3, cp);
        int paths = path1 + path2 + path3;

        cp[n] = paths;
        return paths;
    }


    // TABULATION:
    // Tabulation thinking steps:
    // 1. Storage and meaning (make storage and assign meaning)
    // 2. Identify direction
    // 3. Travel and solve
    static int countPathsTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            }
            else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        int n = 4;
//        System.out.println(countPaths(n, new int[n + 1]));
        System.out.println(countPathsTab(n));
    }

}

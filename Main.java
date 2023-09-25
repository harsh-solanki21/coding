import java.util.*;

public class Main {

    static int countPathsMemoize(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int path1 = countPathsMemoize(n - 1, dp);
        int path2 = countPathsMemoize(n - 2, dp);
        int path3 = countPathsMemoize(n - 3, dp);
        int path = path1 + path2 + path3;
        dp[n] = path;
        return path;
    }

    static int countPathsTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPathsMemoize(n, new int[n + 1]));
        System.out.println(countPathsTabulation(n));
    }

}
package DP;

public class ClimbStairsWithVariableJump {

    // https://www.youtube.com/watch?v=uNqoQ0sNZCM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=3

    // Recursive Solution
    static void staircaseWithVariableJumps(int[] stairs, int currentStep, String ans) {
        if (currentStep == stairs.length) {
            System.out.println(ans);
            return;
        }
        if (currentStep > stairs.length) {
            return;
        }

        for (int i = 1; i <= stairs[currentStep]; i++) {
            staircaseWithVariableJumps(stairs, currentStep + i, ans + i);
        }
    }


    // Tabulation
    static int staircaseVariableJumps(int[] stairs, int[] dp) {
        dp[stairs.length] = 1;
        for (int i = stairs.length - 1; i >= 0; i--) {
            for (int j = 1; j <= stairs[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] stairs = {2, 4, 1, 0, 2, 3};
        staircaseWithVariableJumps(stairs, 0, "");
        System.out.println(staircaseVariableJumps(stairs, new int[stairs.length + 1]));
    }

}

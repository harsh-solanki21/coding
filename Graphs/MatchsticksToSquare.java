package Graphs;

import java.util.Arrays;

public class MatchsticksToSquare {

    // https://leetcode.com/problems/matchsticks-to-square/

    static boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);
        return dfs(matchsticks, new int[4], matchsticks.length - 1, sum / 4);
    }

    private static boolean dfs(int[] matchsticks, int[] sum, int index, int target) {
        if (index == -1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if ((sum[i] + matchsticks[index] > target) || (i > 0 && sum[i] == sum[i - 1])) {
                continue;
            }

            sum[i] += matchsticks[index];

            if (dfs(matchsticks, sum, index - 1, target)) {
                return true;
            }
            sum[i] -= matchsticks[index];
        }

        return false;
    }


    public static void main(String[] args) {
        int[] matchsticks = {1, 1, 2, 2, 2};
        System.out.println(makesquare(matchsticks));

        int[] matchsticks2 = {3, 3, 3, 3, 4};
        System.out.println(makesquare(matchsticks2));
    }

}

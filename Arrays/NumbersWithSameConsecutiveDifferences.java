package Arrays;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {

    // https://leetcode.com/problems/numbers-with-same-consecutive-differences/

    static int[] numsSameConsecDiff(int n, int k) {
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            dfs(i, i, n - 1, k, nums);
        }

        int[] ans = new int[nums.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums.get(i);
        }

        return ans;
    }

    private static void dfs(int num, int digit, int n, int k, List<Integer> numbers) {
        if (n == 0) {
            numbers.add(num);
            return;
        }

        if (digit + k <= 9) {
            dfs(num * 10 + (digit + k), digit + k, n - 1, k, numbers);
        }

        if (k != 0 && digit - k >= 0) {
            dfs(num * 10 + (digit - k), digit - k, n - 1, k, numbers);
        }

    }

}

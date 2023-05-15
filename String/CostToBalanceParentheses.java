package String;

public class CostToBalanceParentheses {

    // Minimum cost to balance parentheses
    // TC = O(n), SC = O(n)
    static int costToBalance(String s) {
        if (s.length() == 0)
            return 0;

        int ans = 0;
        int open = 0, close = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                open++;
            if (s.charAt(i) == ')')
                close++;
        }

        if (open != close)
            return -1;

        int[] nums = new int[s.length()];
        if (s.charAt(0) == '(')
            nums[0] = 1;
        else
            nums[0] = -1;

        if (nums[0] < 0)
            ans += Math.abs(nums[0]);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                nums[i] = nums[i - 1] + 1;
            else
                nums[i] = nums[i - 1] - 1;

            if (nums[i] < 0)
                ans += Math.abs(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = ")))(((";
        System.out.println(costToBalance(s));

        String str = "))((";
        System.out.println(costToBalance(str));
    }

}

package Arrays;

import java.util.Arrays;

public class ProductExceptSelf {

    // https://leetcode.com/problems/product-of-array-except-self/description/


    // TC - O(n), SC - O(3n)
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }

        return ans;
    }


    // TC - O(n), SC - O(~2n)
    static int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int curr = 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }


    // TC - O(n), SC - O(n)
    static public int[] productExceptSelf3(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int prod = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            ans[i] *= prod;
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 2, 3};
//        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
        System.out.println(Arrays.toString(productExceptSelf3(nums)));
    }

}

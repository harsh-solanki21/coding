package Arrays;

import java.util.Arrays;

public class productExceptSelf {

    static public int[] productExceptSelfInNComplexity(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
//        System.out.print(Arrays.toString(ans));

        int prod = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            prod *= nums[j + 1];
            ans[j] *= prod;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
//        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelfInNComplexity(nums)));
    }

}

package Arrays;

import java.util.Arrays;

public class ShuffleIntegers {

    static void rearrange(int[] nums) {
        int n = nums.length / 2;
        for (int i = 0; i < n; i++) {
            int x = nums[i] << 16;
            nums[i] = x | nums[i + n];
        }

        int sixteen1s = (1 << 16) - 1;
        int j = 2 * n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int y = nums[i] & sixteen1s;
            int x = nums[i] >> 16;
            nums[j] = y;
            j--;
            nums[j] = x;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4, 6};
        rearrange(nums);
        System.out.println(Arrays.toString(nums));
    }

}

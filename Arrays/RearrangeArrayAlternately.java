package Arrays;

import java.util.Arrays;

public class RearrangeArrayAlternately {

    // TC - O(n), SC - O(n)
    static int[] rearrange1(int[] nums) {
        int[] temp = nums.clone();
        int low = 0, high = nums.length - 1;
        boolean flag = true;

        for (int i = 0; i < nums.length; i++) {
            if (flag) {
                nums[i] = temp[high--];
            } else {
                nums[i] = temp[low++];
            }
            flag = !flag;
        }

        return nums;
    }

    // TC - O(n)
    static int[] rearrange2(int[] nums) {
        int maxIndex = nums.length - 1, minIndex = 0;
        int mx = nums[nums.length - 1] + 1;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] += (nums[maxIndex] % mx) * mx;
                maxIndex--;
            } else {
                nums[i] += (nums[minIndex] % mx) * mx;
                minIndex++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] / mx;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        System.out.println(Arrays.toString(rearrange1(nums)));
//        System.out.println(Arrays.toString(rearrange2(nums)));
    }

}

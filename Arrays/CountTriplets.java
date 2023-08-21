package Arrays;

import java.util.Arrays;

public class CountTriplets {

    static int countTriplet(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (nums[i] == nums[j] + nums[k]) {
                    count++;
                    j++;
                    k--;
                } else if (nums[i] > nums[j] + nums[k]) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 2};
        System.out.println(countTriplet(nums));
    }

}

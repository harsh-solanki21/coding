package Arrays;

public class MinimumSizeSubarraySum {

    // O(n^2)
    static int minSubArrayLen1(int target, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return 1;
            }
            int sum = nums[i];
            int index = 1;
            for (int j = 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == target) {
                    return index;
                } else if (sum < target) {
                    index++;
                } else {
                    break;
                }
            }
        }
        return 0;
    }

    // O(n)
    static int minSubArrayLen2(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int i = 0, sum = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i++];
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1, 3};
        int target = 7;
        System.out.println(minSubArrayLen1(target, nums));
        System.out.println(minSubArrayLen2(target, nums));
    }

}

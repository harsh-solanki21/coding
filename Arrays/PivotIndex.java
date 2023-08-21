package Arrays;

public class PivotIndex {

    static int pivotIndex(int[] nums) {
        int left = 0, sum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            int right = sum - nums[i];
            if (left == right)
                return i;
            left += nums[i];
            sum -= nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

}

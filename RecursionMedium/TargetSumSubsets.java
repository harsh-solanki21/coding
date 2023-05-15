package RecursionMedium;

public class TargetSumSubsets {

    static void targetSumSubsets(int[] nums, int target, int i, String ans, int sum) {
        if (target == sum) {
            System.out.println(ans);
            return;
        }
        if (i == nums.length || target < sum) {
            return;
        }
        targetSumSubsets(nums, target, i + 1, ans + " " + nums[i], sum + nums[i]);
        targetSumSubsets(nums, target, i + 1, ans, sum);
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 70};
        int target = 70;
        targetSumSubsets(nums, target, 0, "", 0);
    }

}

package RecursionBasic;

public class FindMinMax {

    static int findMin(int[] nums, int n) {
        if (n == 1) {
            return nums[0];
        }
        return Math.min(nums[n - 1], findMin(nums, --n));
//        return Math.max(nums[n - 1], findMin(nums, --n));
    }

    static int maxOfArray(int[] nums, int i) {
        if (i == nums.length - 1) {
            return nums[i];
        }
        int ans = maxOfArray(nums, i + 1);
        if (ans > nums[i]) {
            return ans;
        } else {
            return nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, -5, -4, 8, 6};
//        System.out.println(findMin(nums, nums.length));
        System.out.println(maxOfArray(nums, 0));
    }

}

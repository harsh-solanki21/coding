package Arrays;

public class zerosAtEnd {

    static int[] solve(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (index != i) {
                    nums[i] = 0;
                }
                index++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] ans = solve(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}

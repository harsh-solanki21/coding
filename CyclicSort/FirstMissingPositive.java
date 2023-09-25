package CyclicSort;

public class FirstMissingPositive {

    // Leetcode Hard Amazon Question
    // Here, Ignore negatives because positive number is asked

    static int missingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        // search for first missing number
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        // case 2
        return nums.length + 1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0}; // {3, 4, -1, 1};  // {7, 8, 9, 11, 12};  // {-1, 1, 4, 3};
        System.out.println(missingPositive(nums));
    }

}

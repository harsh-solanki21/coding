package BitManipulation;

public class FindDuplicate {

    // iven an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    //There is only one repeated number in nums, return this repeated number.

    // Two approaches: Cyclic Sort and Bit Manipulation

    // Cyclic Sort Solution
    static int findDuplicate1(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }
        return 0;
    }

    // Bit Manipulation Solution
    static int findDuplicate2(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i] ^ i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate1(nums));
        System.out.println(findDuplicate2(nums));
    }

}

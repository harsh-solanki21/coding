package Arrays;

public class DuplicateZeros {

    static int[] zeros(int[] nums) {
        int count = 0;
        for (int i : nums) {
            count += i == 0 ? 1 : 0;
        }

        int i = nums.length - 1;
        int j = nums.length + count - 1;
        while (i < j && i >= 0) {
            if (j < nums.length) {
                nums[j] = nums[i];
            }
            if (nums[i] == 0) {
                if (j < nums.length) {
                    nums[j] = nums[i];
                }
                j--;
                if (j < nums.length) {
                    nums[j] = nums[i];
                }
            }
            j--;
            i--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 0, 0, 3, 0, 4, 5};
        int[] ans = zeros(a);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}

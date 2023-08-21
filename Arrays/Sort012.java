package Arrays;

public class Sort012 {

    // for 0s and 1s
    static int[] sort01(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] == 0)
                i++;
            else if (nums[j] == 1)
                j--;
            else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }

    // for 0s, 1s and 2s
    static int[] sort012(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        // for 0s and 1s
        int[] nums = {1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0};
        int[] ans = sort01(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }

        System.out.println();

        // for 0s, 1s and 2s
        int[] arr = {1, 0, 0, 1, 0, 1, 1, 2, 0, 2, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0};
        int[] result = sort012(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}

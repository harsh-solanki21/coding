package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    // XOR
    static int findDuplicateXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        for (int i = 1; i < nums.length; i++) {
            ans ^= i;
        }
        return ans;
    }

    // Cyclic Sort
    static int findDuplicate(int[] nums) {
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

    static List<Integer> findAllDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
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
                ans.add(nums[j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // findDuplicate
        int[] num = {6, 3, 1, 5, 4, 3, 2};
        System.out.println(findDuplicateXOR(num));

        // findDuplicate
        int[] nums = {6, 3, 1, 5, 4, 3, 2};
        System.out.println(findDuplicate(nums));

        // findAllDuplicates
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findAllDuplicates(arr));

    }

}

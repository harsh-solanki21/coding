package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedNumbers {

    // Google Question
    // Find all numbers disappeared in an array

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findAllMissing(nums);
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }

    static List<Integer> findAllMissing(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }
        // just find missing numbers
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if(nums[index] != index+1) {
                ans.add(index+1);
            }
        }
        return ans;
    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}

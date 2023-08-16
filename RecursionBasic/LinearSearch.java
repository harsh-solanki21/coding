package RecursionBasic;

import java.util.*;

public class LinearSearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 8, 8, 9, 8, 12, 8};
        int target = 8, index = 0;
        ArrayList<Integer> ans = search(nums, target, index, new ArrayList<>());
        System.out.println(ans);
    }

    static ArrayList<Integer> search(int[] nums, int target, int i, ArrayList<Integer> list) {
        if (nums[i] == target) {
            list.add(i);
        }
        if (i == nums.length - 1) {
            return list;
        }
        return search(nums, target, i + 1, list);
    }

}

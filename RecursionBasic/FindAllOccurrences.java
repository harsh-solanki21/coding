package RecursionBasic;

import java.util.ArrayList;

public class FindAllOccurrences {

    // Return ArrayList as an answer without taking ArrayList in arguments
    static ArrayList<Integer> findAllIndex(int[] nums, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == nums.length){
            return list;
        }
        if (nums[index] == target){
            list.add(index);
        }

        ArrayList<Integer> ans = findAllIndex(nums, target, ++index);
        list.addAll(ans);

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 6, 7};
        int target = 6;
        System.out.println(findAllIndex(nums, target, 0));
    }

}

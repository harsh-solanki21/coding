package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, nums.length, new ArrayList<>(), ans);
        return ans;
    }

    static void solve(int[] nums, int n, List<Integer> list, List<List<Integer>> ans) {
        if (n == 0) {
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        }
        list.add(nums[n - 1]);
        solve(nums, n - 1, list, ans);
        list.remove(list.size() - 1);
        solve(nums, n - 1, list, ans);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = subsets(nums);
        System.out.println(Arrays.toString(ans.toArray()));
    }

}

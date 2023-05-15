package RecursionMedium;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesIterative {

    // Power Set: Print all the possible subsequences of the String

    // Total no. of subsets we will have is 2^n
    // So, the Time Complexity = O(n * 2^n)
    // Space complexity = O(n * 2^n)   i.e. 2^n is total subsets and n is space taken by each subset
    static List<List<Integer>> subsequence(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i : nums) {
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(i);
                outer.add(internal);
            }
        }
        return outer;
    }


    // Other Approach
    // Time Complexity = O(n * 2^n)
    // Space complexity = O(1)
    static ArrayList<String> AllPossibleStrings(String s) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < (1 << s.length()); i++) {
            String sub = "";
            for (int j = 0; j < s.length(); j++) {
                //check if the ith bit is set or not
                if ((i & (1 << j)) != 0) {
                    sub += s.charAt(j);
                }
            }
            if (sub.length() > 0) {
                ans.add(sub);
            }
        }
//        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        // for first approach
//        int[] nums = {1, 2, 3};
//        List<List<Integer>> ans = subsequence(nums);
//        for (List<Integer> list : ans) {
//            System.out.println(list);
//        }

        // for the other approach
        String s = "abc";
        ArrayList<String> ans = AllPossibleStrings(s);
        for (String it : ans) {
            System.out.print(it + " ");
        }
    }

}

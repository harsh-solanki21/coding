package RecursionMedium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // No. of permutations = str.length()!
    // TC - O(n * n!), SC - O(n)

    // Print Permutations
    static void permutations(String s, String ans) {
        if (s.isEmpty()) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String first = s.substring(0, i);
            String second = s.substring(i + 1);
            permutations(first + second, ans + ch);
        }
    }

    // Return ArrayList of Permutations
    static ArrayList<String> permutationsList(String s, String ans) {
        if (s.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch = s.charAt(0);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i);
            result.addAll(permutationsList(s.substring(1), first + ch + second));
        }
        return result;
    }

    // Find total Permutation count
    static int permutationsCount(String s, String ans) {
        if (s.isEmpty()) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String first = s.substring(0, i);
            String second = s.substring(i + 1);
            count += permutationsCount(first + second, ans + ch);
        }
        return count;
    }


    // Permutation Sequence
//    The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
//
//    By listing and labeling all the permutations in order, we get the following sequence for n = 3:
//            "123"
//            "132"
//            "213"
//            "231"
//            "312"
//            "321"
//    Given n and k, return the kth permutation sequence.
//
//    Example 1:
//    Input: n = 3, k = 3
//    Output: "213"

    static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);

        StringBuilder ans = new StringBuilder();
        k--;
        while (true) {
            ans.append(nums.get(k / fact));
            nums.remove(k / fact);
            if (nums.isEmpty())
                break;
            k %= fact;
            fact /= nums.size();

        }
        return ans.toString();
    }


    public static void main(String[] args) {
        permutations("abc", "");

//        System.out.println(permutationsList("abc", ""));
//
//        System.out.println(permutationsCount("abc", ""));
//
//        System.out.println(getPermutation(4, 9));
    }

}

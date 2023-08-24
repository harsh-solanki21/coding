package RecursionMedium;

import java.util.ArrayList;

public class Subsequences {

    // No. of subsequences = 2 ^ length of string
    // The simple intuition behind it is take a character and don't take the character

//                                          ("", "abc")
//                      ("a", "bc")                                     ("", "bc")
//          ("ab", "c")             ("a", "c")               ("b", "c")           ("", "c")
//    ("abc", "") ("ab", "")  ("ac", "") ("a", "")     ("bc", "") ("b", "")  ("c", "") ("", "")

    // A subsequence of a string is a new string that is formed from the original string by deleting some(can be none)
    // of the characters without disturbing the relative position of the remaining characters.

    // TC - O(2^n), SC - O(n)

    // Approach 1
    // for ArrayList return type
    static ArrayList<String> subSeqList(String ans, String str) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = subSeqList(ans + ch, str.substring(1));
        ArrayList<String> right = subSeqList(ans, str.substring(1));
        left.addAll(right);
        return left;
    }


    // Approach 2
    static ArrayList<String> getSubsequence(String s) {
        if (s.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        char ch = s.charAt(0);
        ArrayList<String> res = getSubsequence(s.substring(1));
        ArrayList<String> ans = new ArrayList<>();
        for (String str : res) {
            ans.add("" + str);
            ans.add(ch + str);
        }
        return ans;
    }


    // Print Subsequence
    // Larger string will generate large amount of subsequences and after a limit, ArrayList won't be able to store those amount of
    // data in itself because of memory limit. For example,
    // n (length of string) -> 2 ^ n-1 * n (bytes needed) (characters in ArrayList)
    // 31 -> 31 GB memory (memory means RAM)
    // So, in the below function, we are generating the answer string at a time and displaying it. We are not storing it.
    // So, memory won't be a concern.
    static void printSubsequence(String ans, String str) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        printSubsequence(ans + ch, str.substring(1));
        printSubsequence(ans, str.substring(1));
    }


    public static void main(String[] args) {
//        System.out.println(subSeqList("", "abc"));
        System.out.println(getSubsequence("abc"));
//        printSubsequence("", "abc");
    }

}

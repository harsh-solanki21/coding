package RecursionMedium;

import java.util.TreeSet;

public class DistinctSubsequences {

    // Print unique subsequences
    // This will find duplicate subsequences also, but the TreeSet will ignore duplicate values.
    // So, we will get unique values.
    static void uniqueSubsequences(TreeSet<String> st, String ans, String s) {
        if (s.isEmpty()) {
            st.add(ans);
            return;
        }
        char ch = s.charAt(0);
        uniqueSubsequences(st, ans + ch, s.substring(1));
        uniqueSubsequences(st, ans, s.substring(1));
    }

    public static void main(String[] args) {
        String s = "aaa";
        TreeSet<String> st = new TreeSet<>();
        uniqueSubsequences(st, "", s);
        for (String str : st) {
            System.out.println(str);
        }
    }

}

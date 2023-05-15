package String;

import java.util.ArrayList;
import java.util.List;

public class FindAndReplacePattern {

    // https://leetcode.com/problems/find-and-replace-pattern/

    static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private static boolean check(String words, String pattern) {
        for (int i = 0; i < words.length(); i++) {
            if (words.indexOf(words.charAt(i)) != pattern.indexOf(pattern.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words, pattern));
    }

}

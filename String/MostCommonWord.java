package String;

import java.util.HashMap;

public class MostCommonWord {

    // https://leetcode.com/problems/most-common-word/

    static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");
        HashMap<String, Integer> hm = new HashMap<>();

        for (String s : words) {
            if (hm.containsKey(s)) {
                int oldVal = hm.get(s);
                int newVal = oldVal + 1;
                hm.put(s, newVal);
            } else {
                hm.put(s, 1);
            }
        }

        int maxFreq = 0;
        String word = "";
        for (String s : words) {
            if (hm.get(s) > maxFreq && !isBanned(s, banned)) {
                maxFreq = hm.get(s);
                word = s;
            }
        }

        return word;
    }

    private static boolean isBanned(String word, String[] banned) {
        for (String ban : banned) {
            if (word.equals(ban)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

}

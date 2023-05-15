package String;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

//    Question:
//    You are given two string arrays words1 and words2.
//    A string b is a subset of string a if every letter in b occurs in a including multiplicity.
//    For example, "wrr" is a subset of "warrior" but is not a subset of "world".
//    A string a from words1 is universal if for every string b in words2, b is a subset of a.
//
//    Return an array of all the universal strings in words1. You may return the answer in any order.

    static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] target = new int[26];

        for (String word : words2) {
            int[] temp = new int[26];
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
                target[ch - 'a'] = Math.max(target[ch - 'a'], temp[ch - 'a']);
            }
        }

        for (String word : words1) {
            int[] arr = new int[26];
            for (char ch : word.toCharArray()) {
                arr[ch - 'a']++;
            }
            if (subset(arr, target)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private static boolean subset(int[] src, int[] dest) {
        for (int i = 0; i < 26; i++) {
            if (dest[i] > src[i])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};

        System.out.println(wordSubsets(words1, words2));
    }

}

package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    //  https://leetcode.com/problems/find-all-anagrams-in-a-string/

    static List<Integer> findAnagrams(String s, String p) {
        int[] temp = new int[26];
        int[] target = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
        }

        // sliding window, O(n)
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            int len = end - start + 1;

            // able to compose of anagram
            if (temp[c - 'a'] < target[c - 'a']) {
                temp[c - 'a']++;
            } else if (target[c - 'a'] == 0) { // current letter doesn't exist in p, reset window
                start = end + 1;
                end = start;
                Arrays.fill(temp, 0);
                continue;
            } else { // current letter exists in p, but is extra, shrink window
                temp[s.charAt(start) - 'a']--;
                start++;
                continue;
            }

            // is an anagram, save start index, shrink window
            if (len == p.length()) {
                res.add(start);
                temp[s.charAt(start) - 'a']--;
                start++;
            }

            end++; // expand window
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

}

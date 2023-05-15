package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    // https://leetcode.com/problems/longest-repeating-character-replacement/

    static int characterReplacement(String s, int k) {
        int maxLen = 0, maxf = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < s.length(); r++) { //left and right pointers
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1); //put character and the number of this character into map
            maxf = Math.max(maxf, map.get(s.charAt(r))); //the number of the most frequency number between left and right pointer
            if (maxf + k < r - l + 1) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1); //if it is too long(has exceeded number), let left++ , and number of left character --
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1); //update maxLength
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }

}

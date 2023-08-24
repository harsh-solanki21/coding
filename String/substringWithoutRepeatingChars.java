package String;

import java.util.Arrays;
import java.util.HashMap;

public class substringWithoutRepeatingChars {

    // Approach 1
    // Longest Substring Without Repeating Characters
    static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int[] longestIndex = new int[]{0, 1};
        for (int i = 0; i < s.length(); i++) {
            Character atIndex = s.charAt(i);
            if (map.containsKey(atIndex)) {
                start = Math.max(start, map.get(atIndex) + 1);
            }
            if (longestIndex[1] - longestIndex[0] < i + 1 - start) {
                longestIndex[0] = start;
                longestIndex[1] = i + 1;
            }
            map.put(atIndex, i);
        }
        return longestIndex[1] - longestIndex[0];
    }


    // Approach 2
    static int longestUniqueSubstr(String str) {
        int ans = 0;
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);

        int i = 0;
        for (int j = 0; j < str.length(); j++) {
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);
            ans = Math.max(ans, j - i + 1);
            lastIndex[str.charAt(j)] = j;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(longestUniqueSubstr(s));
    }

}

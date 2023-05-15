package String;

import java.util.HashMap;

public class MinimumWindowSubstring {

    // Approach 1
    static String minWindow(String S, String T) {
        if (S == null || S.isEmpty() || T == null || T.isEmpty())
            return "";

        int i = 0, j = 0;
        int[] Tmap = new int[256];
        int[] Smap = new int[256];
        for (int k = 0; k < T.length(); k++) {
            Tmap[T.charAt(k)]++;
        }

        int found = 0;
        int length = Integer.MAX_VALUE;
        String res = "";
        while (j < S.length()) {
            if (found < T.length()) {
                if (Tmap[S.charAt(j)] > 0) {
                    Smap[S.charAt(j)]++;
                    if (Smap[S.charAt(j)] <= Tmap[S.charAt(j)]) {
                        found++;
                    }
                }
                j++;
            }
            while (found == T.length()) {
                if (j - i < length) {
                    length = j - i;
                    res = S.substring(i, j);
                }
                if (Tmap[S.charAt(i)] > 0) {
                    Smap[S.charAt(i)]--;
                    if (Smap[S.charAt(i)] < Tmap[S.charAt(i)]) {
                        found--;
                    }
                }
                i++;
            }
        }

        return res;
    }


    // Approach 2
    // Space-optimized Sliding Window using Two Pointers
    // Time Complexity: O(S + T)
    // Space Complexity: O(T)
    // S = length of String s. T = length of String t
    static String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() < t.length() || t.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0;
        int end = 0;
        int charTLeft = t.length();
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        while (end < s.length()) {
            char eChar = s.charAt(end);
            if (map.containsKey(eChar)) {
                int count = map.get(eChar);
                if (count > 0) {
                    charTLeft--;
                }
                map.put(eChar, count - 1);
            }
            end++;

            while (charTLeft == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char sChar = s.charAt(start);
                if (map.containsKey(sChar)) {
                    int count = map.get(sChar);
                    if (count == 0) {
                        charTLeft++;
                    }
                    map.put(sChar, count + 1);
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
        System.out.println(minWindow2(s, t));
    }

}

package String;

import java.util.Arrays;
import java.util.HashMap;

public class CountKDistinctCharacters {

    // Approach 1 => TC - O(n^3), Sc - O(n)
    static int countKDistinct(String str, int distinct) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                String sub = str.substring(i, j);
                HashMap<Character, Integer> map = new HashMap<>();
                for (int k = 0; k < sub.length(); k++) {
                    if (map.containsKey(sub.charAt(k))) {
                        map.put(sub.charAt(k), map.get(sub.charAt(k)) + 1);
                    } else {
                        map.put(sub.charAt(k), 1);
                    }
                }
                if (map.size() == distinct) {
                    count++;
                }
            }
        }
        return count;
    }

    // Approach 2 => TC - O(n^2)
    static int countKDist(String str, int k) {
        int result = 0;
        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int distinctChars = 0;
            Arrays.fill(count, 0);

            for (int j = i; j < str.length(); j++) {
                if (count[str.charAt(j) - 'a'] == 0) {
                    distinctChars++;
                }
                count[str.charAt(j) - 'a']++;

                if (distinctChars == k) {
                    result++;
                }
            }
        }

        return result;
    }

    // Approach 3 => TC - O(n)
    static int countKDistinctChars(String str, int k) {
        return helper(str, k) - helper(str, k - 1);
    }

    private static int helper(String str, int k) {
        int i = 0, j = 0, currCount = 0;
        int result = 0;
        int[] count = new int[26];

        while (j < str.length()) {
            int index = str.charAt(j) - 'a';
            count[index]++;

            if (count[index] == 1) {
                currCount++;
            }

            while (currCount > k) {
                count[str.charAt(i) - 'a']--;
                if (count[str.charAt(i) - 'a'] == 0) {
                    currCount--;
                }
                i++;
            }

            result += (j - i + 1);
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "abcbaa";
        int k = 3;

        System.out.println(countKDistinct(str, k));
        System.out.println(countKDist(str, k));
        System.out.println(countKDistinctChars(str, k));
    }

}

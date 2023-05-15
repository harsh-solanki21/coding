package String;

import java.util.*;

public class GroupAnagrams {


    // APPROACH - 1 (TLE)
    // Brute force, checking all combinations
    // TC - O(n ^ 2)
    static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] flag = new boolean[strs.length]; // to see if string is already part of other answer

        for (int i = 0; i < strs.length; i++) {
            List<String> templist = new ArrayList<>();

            if (!flag[i]) {
                templist.add(strs[i]);
                flag[i] = true;
            }

            for (int j = i + 1; j < strs.length; j++) {
                if (!flag[j]) {
                    if (checkAnagram(strs[i], strs[j])) {
                        flag[j] = true;
                        templist.add(strs[j]);
                    }
                }
            }

            if (templist.size() > 0) {
                result.add(new ArrayList<>(templist));
            }
        }

        return result;
    }

    private static boolean checkAnagram(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>(); // character, count

        for (Character ch : s1.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        // now check s2 in s1
        for (Character ch : s2.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            } else {
                int count = map.get(ch);
                if (count == 0) return false;
                map.put(ch, count - 1);
            }
        }

        // now iterate map and see count, all must be zero
        for (Map.Entry<Character, Integer> entries : map.entrySet()) {
            if (entries.getValue() != 0) {
                return false;
            }
        }

        return true;
    }




    // APPROACH - 2
    // Idea: sort the individual string and make it key in hashmap,
    // if new string when sorted matches any key in hashmap, put that in same bucket.
    // TC - O(n * k logk), K is max length of string
    static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String current : strs) {
            // 1st let's sort current string and then put in hashmap
            char[] characters = current.toCharArray();
            Arrays.sort(characters);
            String sortedCurrent = new String(characters);

            if (!map.containsKey(sortedCurrent)) {
                map.put(sortedCurrent, new ArrayList<>());
            }

            map.get(sortedCurrent).add(current);
        }

        // now adding all values from hashmap to our result
        ans.addAll(map.values());

        return ans;
    }




    // APPROACH - 3
    // Most optimal approach
    // TC - O(n * k), K is max length of string
    static List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        // instead of sorting individual strings we make different string representation using
        // count of characters and make it key in our hashmap, rather than making
        // sorted string as our key like in 2nd approach
        for (String current : strs) {
            int[] count = new int[26];
            for (char ch : current.toCharArray()) {
                count[ch - 'a']++;
            }

            // now generating key from above count,
            // eg: key will be like 1#0#0#1#0#.....
            // where 1 means character is present in string 0 means no character in that position

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
                sb.append("#"); // some delimiter only to make unique key in map, nothing fancy
            }

            String mykey = sb.toString();
            map.putIfAbsent(mykey, new ArrayList<>());
            map.get(mykey).add(current);
        }

        ans.addAll(map.values());
        return ans;
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams2(strs));
        System.out.println(groupAnagrams3(strs));
    }

}

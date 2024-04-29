package Graphs;

import java.util.*;

public class WordLadder2 {


    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.offer(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        List<List<String>> ans = new ArrayList<>();
        int level = 0;

        while (!q.isEmpty()) {
            ArrayList<String> vec = q.poll();
            if (vec.size() > level) {
                level++;
                for (String s : usedOnLevel) {
                    set.remove(s);
                }
            }

            String word = vec.get(vec.size() - 1);
            if (word.equals(endWord)) {
                if (ans.isEmpty()) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }

            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] replacedArr = word.toCharArray();
                    replacedArr[i] = c;
                    String replacedWord = new String(replacedArr);
                    if (set.contains(replacedWord)) {
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println(findLadders(beginWord, endWord, wordList));
    }

}

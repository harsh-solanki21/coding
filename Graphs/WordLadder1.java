package Graphs;

import java.util.*;

public class WordLadder1 {


    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int count = 0;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int k = 0; k < size; k++) {  // will have to crete separate class to maintain count if you want to remove this loop
                String word = q.poll();
                if (word.equals(endWord)) {
                    return count;
                }
                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] arr = word.toCharArray();
                        arr[i] = ch;
                        String midWord = new String(arr);
                        if (set.contains(midWord)) {
                            q.offer(midWord);
                            set.remove(midWord);
                        }
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        String[] str = {"poon", "plee", "same", "poie", "plea", "plie", "poin"};
        List<String> wordList = new ArrayList<>(Arrays.asList(str));
        String startWord = "toon", targetWord = "plea";
        System.out.println(ladderLength(startWord, targetWord, wordList));
    }

}

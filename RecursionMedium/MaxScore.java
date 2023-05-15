package RecursionMedium;

public class MaxScore {

    // Question:
    // 1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet from a to z.
    // 2. You have to find  the maximum score of any valid set of words formed by using the given alphabets.
    // 3. A word cannot be used more than one time.
    // 4. Each alphabet can be used only once.
    // 5. It is not necessary to use all the given alphabets.

    static int maxScore(String[] words, char[] letters, int[] score) {
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score.length == 0) {
            return 0;
        }

        int[] freq = new int[26];
        for (char c : letters) {
            freq[c - 'a']++;
        }

        return helper(words, freq, score, 0);
    }

    static int helper(String[] words, int[] freq, int[] score, int idx) {
        if (idx == words.length) {
            return 0;
        }

        int scoreNo = 0 + helper(words, freq, score, idx + 1);  // not included

        // word to include
        int scoreWord = 0;
        String word = words[idx];
        boolean flag = true;  // true if word can be included

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (freq[ch - 'a'] == 0) {
                flag = false;
            }

            freq[ch - 'a']--;
            scoreWord += score[ch - 'a'];
        }

        int scoreYes = 0;
        if (flag) {
            scoreYes = scoreWord + helper(words, freq, score, idx + 1);
        }

        // adding frequency again to match it with other words
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }

        return Math.max(scoreNo, scoreYes);
    }

    public static void main(String[] args) {
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'b', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(maxScore(words, letters, score));
    }

}

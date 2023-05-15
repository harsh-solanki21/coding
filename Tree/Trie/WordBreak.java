package Tree.Trie;

import static Tree.Trie.Trie.*;

public class WordBreak {

    // https://leetcode.com/problems/word-break/

    static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secPart = key.substring(i);
            if (search(firstPart) && wordBreak(secPart)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesamsung";

        for (String i : words) {
            insert(i);
        }

        System.out.println(wordBreak(key));
    }

}

package Tree.Trie;

import static Tree.Trie.Trie.*;

public class CountUniqueSubstring {

    // https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/

    // Given a string of length n of lowercase alphabet characters, we need to count total number of distinct substrings of this string.

    // Example:
    // str = "ababa", ans = 10
    // all unique prefix of all suffix
    // SUFFIX           PREFIX OF SUFFIX
    // ababa            a, ab, aba, abab, ababa
    // baba             b, ba, bab, baba
    // aba              (no unique prefixes)
    // ba               (no unique prefixes)
    // a                (no unique prefixes)
    // ""               ""

    // total nodes of trie = count of unique prefix

    static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNode((root.children[i]));
            }
        }
        return count + 1;
    }


    public static void main(String[] args) {
        String s = "apple";
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            insert(suffix);
        }
        System.out.println(countNode(root));
    }


}

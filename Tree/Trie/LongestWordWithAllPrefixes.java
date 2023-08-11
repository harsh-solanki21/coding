package Tree.Trie;

import static Tree.Trie.Trie.*;

public class LongestWordWithAllPrefixes {

    // Find the longest string in words such that every prefix of it is also in words.

    static String ans = "";

    static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].isEndOfWord) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};  // ans: apple
        // There are two answers: apply and apple
        // But the answer would be apple because it is lexicographically smaller than apply.

        String[] words2 = {"ab", "abc", "abcd"};  // ans: ""
        // Because a doesn't exist

        for (String i : words) {
            insert(i);
        }
        longestWord(root, new StringBuilder());
        System.out.println(ans);
    }

}

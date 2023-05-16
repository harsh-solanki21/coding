package Tree.Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie_HashMap {

    TrieNode root;

    static class TrieNode {
        boolean isEnd;
        Map<Character, TrieNode> children;

        public TrieNode() {
            isEnd = false;
            children = new HashMap<>();
        }

    }

    public Trie_HashMap() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * Let n be the length of the word.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char letter : word.toCharArray()) {
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
        }
        node.isEnd = true;
    }

    /**
     * Checks if the word is in the trie.
     * Let n be the length of the word.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean search(String word) {
        TrieNode node = root;

        for (char letter : word.toCharArray()) {
            if (node.children.containsKey(letter)) {
                node = node.children.get(letter);
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * Checks if there is any word in the trie that starts with the
     * given prefix.
     * Let n be the length of the word.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char letter : prefix.toCharArray()) {
            if (node.children.containsKey(letter)) {
                node = node.children.get(letter);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String word = "Trie";
        Trie_HashMap trie = new Trie_HashMap();
        trie.insert(word);
        boolean wordFound = trie.search(word);
        System.out.println(wordFound); // True
        boolean prefixFound = trie.startsWith("Tr");
        System.out.println(prefixFound); // True
    }

}

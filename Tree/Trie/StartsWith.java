package Tree.Trie;

import static Tree.Trie.Trie.*;

public class StartsWith {

    // Create a function that returns true if there is a previously inserted string that has the prefix, and false otherwise.

    static boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "app", "mango", "man", "woman"};
        String prefix = "moon";

        for (String i : words) {
            insert(i);
        }

        System.out.println(startsWith(prefix));
    }

}

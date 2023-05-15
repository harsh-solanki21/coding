package Tree.Trie;

public class Trie {

    // Trie supports search, insert and delete operations in O(L) time, where L is the length of the string.

    static Node root = new Node();

    static class Node {
        Node[] children;
        boolean endOfWord;

        Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }


    // TC - O(L), L = length of string
    static void insert(String str) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.endOfWord = true;
    }


    // Returns true if key presents in trie, else false
    // TC - O(L), L = length of string
    static boolean search(String key) {
        Node node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return node.endOfWord;
    }


    static boolean isEmpty(Node root) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null)
                return false;
        }
        return true;
    }

    // Recursive function to delete a key from given Trie
    static Node remove(Node root, String key, int depth) {
        // If tree is empty
        if (root == null)
            return null;

        // If last character of key is being processed
        if (depth == key.length()) {

            // This node is no more end of word after
            // removal of given key
            if (root.endOfWord)
                root.endOfWord = false;

            // If given is not prefix of any other word
            if (isEmpty(root)) {
                root = null;
            }

            return root;
        }

        // If not last character, recur for the child
        // obtained using ASCII value
        int index = key.charAt(depth) - 'a';
        root.children[index] = remove(root.children[index], key, depth + 1);

        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (isEmpty(root) && !root.endOfWord) {
            root = null;
        }

        return root;
    }


    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "answer", "any", "by", "bye", "their"};

        // Construct trie
        for (String i : words) {
            insert(i);
        }

        // Search for different keys
        System.out.println(search("the"));
        System.out.println(search("these"));
        System.out.println(search("their"));
        System.out.println(search("thaw"));

        // Remove key
        remove(root, "thaw", 0);

    }

}

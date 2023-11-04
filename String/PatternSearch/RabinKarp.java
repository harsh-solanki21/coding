package String.PatternSearch;

public class RabinKarp {

    // TC - O(N * M), where N is length of text and M is length of pattern
    // SC - O(1)

    private static final int PRIME = 101;

    static void search(String text, String pattern) {
        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, pattern.length()));

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + pattern.length()).equals(pattern)) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            if (i < text.length() - pattern.length()) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + pattern.length()), pattern.length());
            }
        }
    }

    private static long calculateHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private static long updateHash(long prevHash, char oldChar, char newChar, int patternLen) {
        long newHash = (prevHash - oldChar) / PRIME;
        newHash += newChar * Math.pow(PRIME, patternLen - 1);
        return newHash;
    }

    public static void main(String[] args) {
        String text = "This is the string that we have to search for a pattern";
        String pattern = "for";
        search(text, pattern);
    }

}

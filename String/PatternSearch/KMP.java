package String.PatternSearch;

public class KMP {

    // The KMP matching algorithm uses degenerating property (pattern having same sub-patterns appearing more than once in the pattern)
    // It improves the worst case complexity to O(n).

    static void KMPSearch(String text, String pattern) {
        // create lps[] that will hold the longest prefix suffix values for pattern
        int[] lps = new int[pattern.length()];
        int j = 0;

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pattern, lps);

        int i = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == pattern.length()) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }

    static void computeLPSArray(String pattern, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "This is the text to search the pattern";
        String pattern = "the";
        KMPSearch(text, pattern);
    }

}

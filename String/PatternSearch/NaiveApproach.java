package String.PatternSearch;

public class NaiveApproach {

    // This is the brute force approach to find pattern in string
    // Time complexity = O(m(n-m+1))

    static int patternMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i < n - m; i++) {
            int j = 0;
            while (j < m && pattern.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == m)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "This is the string that we have to search for a pattern";
        String pattern = "for";
        System.out.println("Pattern found at Index " + patternMatching(text, pattern));
    }

}

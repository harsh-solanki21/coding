package RecursionMedium;

public class DistinctSubsequencesIterative {

    // Given two strings s and t, return the number of distinct subsequences of s which equals t.
    static int uniqueSubsequences(String s, String t) {
        int[][] memoize = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j <= s.length(); j++) {
            memoize[0][j] = 1;
        }

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j))
                    memoize[i + 1][j + 1] = memoize[i][j] + memoize[i + 1][j];
                else
                    memoize[i + 1][j + 1] = memoize[i + 1][j];
            }
        }
        return memoize[t.length()][s.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(uniqueSubsequences(s, t));
    }

}

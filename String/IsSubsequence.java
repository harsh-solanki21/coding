package String;

public class IsSubsequence {

    // Given two strings s and t, return true if s is a subsequence of t, or false otherwise

    // A subsequence of a string is a new string that is formed from the original string by deleting some(can be none)
    // of the characters without disturbing the relative position of the remaining characters.

    static boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(count)) {
                count++;
            }
            if (count == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("adb", "ahbgde"));
    }

}

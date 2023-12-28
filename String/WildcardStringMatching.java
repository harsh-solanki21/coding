package String;

public class WildcardStringMatching {

//    Given two strings wild and pattern.
//    Determine if the given two strings can be matched given that, wild string may contain * and ? but string pattern will not.
//    * and ? can be converted to another character according to the following rules:
//    * --> This character in string wild can be replaced by any sequence of characters, it can also be replaced by an empty string.
//    ? --> This character in string wild can be replaced by any one character.


    static boolean match(String wild, String pattern) {
        return wildcardMatching(wild.length(), pattern.length(), wild, pattern);
    }

    static boolean wildcardMatching(int n, int m, String wild, String pattern) {
        if (m == 0 && n == 0) {
            return true;
        } else if (m == 0 || n == 0) {
            return false;
        }

        if (wild.charAt(n - 1) == pattern.charAt(m - 1) || wild.charAt(n - 1) == '?') {
            return wildcardMatching(n - 1, m - 1, wild, pattern);
        } else if (wild.charAt(n - 1) == '*') {
            return wildcardMatching(n - 1, m - 1, wild, pattern) || wildcardMatching(n, m - 1, wild, pattern);
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        String wild = "ge?ks*", pattern = "geeksforgeeks";
        System.out.println(match(wild, pattern));
    }

}

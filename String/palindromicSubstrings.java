package String;

public class palindromicSubstrings {

    static void substrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (isPalindromic(str))
                    System.out.println(str);
            }
        }
    }

    static boolean isPalindromic(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abccbc";
        substrings(s);
    }

}

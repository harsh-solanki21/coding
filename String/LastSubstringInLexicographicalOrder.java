package String;

public class LastSubstringInLexicographicalOrder {

    // Approach 1 => TC - O(n^3), SC - O(n)
    static String findLastSubstring1(String str) {
        String lastSubstr = "";

        for (int i = 0; i < str.length(); i++) {
            String curSubstr = "";
            for (int j = i; j < str.length(); j++) {
                curSubstr += str.charAt(j);

                if (curSubstr.compareTo(lastSubstr) > 0) {
                    lastSubstr = curSubstr;
                }
            }
        }

        return lastSubstr;
    }

    // Approach 2 => TC - O(n^2), SC - O(n)
    static String findLastSubstring2(String str) {
        String lastSubstr = "", curSuffix = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            curSuffix = str.charAt(i) + curSuffix;
            if (curSuffix.compareTo(lastSubstr) > 0) {
                lastSubstr = curSuffix;
            }
        }

        return lastSubstr;
    }

    // Approach 3 => TC - O(n)
    static String findLastSubstring3(String str) {
        int i = 0, j = 1, k = 0;

        while (j + k < str.length()) {
            if (str.charAt(i + k) == str.charAt(j + k)) {
                k++;
            } else if (str.charAt(i + k) > str.charAt(j + k)) {
                j = j + k + 1;
                k = 0;
            } else {
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            }
        }

        return str.substring(i);
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(findLastSubstring1(str));
        System.out.println(findLastSubstring2(str));
        System.out.println(findLastSubstring3(str));
    }

}

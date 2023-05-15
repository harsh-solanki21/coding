package RecursionMedium;

public class RemoveAllAdjacentDuplicates {

    // Given a string s, remove all its adjacent duplicate characters recursively.

    static String remove(String s) {
        int count = 1;
        StringBuffer str = new StringBuffer(s);
        return recursive(str, count);
    }

    private static String recursive(StringBuffer s, int count) {
        if (s.length() == 0) {
            return "";
        }
        if (count > 0) {
            count = 0;
            char ch = ' ';
            for (int i = 0; i < s.length() - 1; ) {
                if (s.charAt(i) == s.charAt(i + 1) || ch == s.charAt(i)) {
                    count++;
                    ch = s.charAt(i);
                    s.delete(i, i + 1);
                } else {
                    i++;
                    ch = ' ';
                }

            }
            if (s.charAt(s.length() - 1) == ch) {
                s.delete(s.length() - 1, s.length());
            }
            return recursive(s, count);
        } else {
            String p = String.valueOf(s);
            return p;
        }
    }

    public static void main(String[] args) {
        System.out.println(remove("geeksforgeek"));
        System.out.println(remove("abccbccba"));
    }

}

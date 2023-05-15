package String;

public class substrings {

    // No. of Substrings = n*(n+1) / 2
    static void printSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        printSubstrings(s);
    }

}

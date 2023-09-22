package RecursionMedium;

public class Encodings {

    // 1 = a, 2 = b, c = 3, .., z = 26
    static void printEncodings(String s, String ans) {
        if (s.isEmpty()) {
            System.out.println(ans);
        } else if (s.length() == 1) {
            char ch = s.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chVal = ch - '0';
                char code = (char) ('a' + chVal - 1);
                ans += code;
                System.out.println(ans);
            }
        } else {
            char ch = s.charAt(0);
            String str1 = s.substring(1);
            if (ch == '0') {
                return;
            } else {
                int chVal = ch - '0';
                char code = (char) ('a' + chVal - 1);
                printEncodings(str1, ans + code);
            }

            String ch12 = s.substring(0, 2);
            String str2 = s.substring(2);

            int ch12Val = Integer.parseInt(ch12);
            if (ch12Val <= 26) {
                char code = (char) ('a' + ch12Val - 1);
                printEncodings(str2, ans + code);
            }
        }
    }

    public static void main(String[] args) {
        printEncodings("123", "");
    }

}

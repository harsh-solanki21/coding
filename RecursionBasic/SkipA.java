package RecursionBasic;

public class SkipA {

    // When return is void
    static void skip(String ans, String str) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        if (ch == 'a') {
            skip(ans, str.substring(1));
        } else {
            skip(ans + ch, str.substring(1));
        }
    }

    // When return is String
    static String skip(String str) {
        if (str.isEmpty()) {
            return "";
        }

        char ch = str.charAt(0);
        if (ch == 'a') {
            return skip(str.substring(1));
        } else {
            return ch + skip(str.substring(1));
        }
    }

    static String skipString(String str, String skip) {
        if (str.isEmpty()) {
            return "";
        }

        char ch = str.charAt(0);
        if (ch == skip.charAt(0) && str.substring(0, Math.min(skip.length(), str.length())).equals(skip)) {
            return skipString(str.substring(skip.length()), skip);
        } else {
            return ch + skipString(str.substring(1), skip);
        }
    }

    public static void main(String[] args) {
        skip("", "baccdah");
        System.out.println(skip("baccdah"));
        System.out.println(skipString("thisappleisgoodapp", "apple"));
    }

}

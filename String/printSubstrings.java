package String;

public class printSubstrings {

    static void printSubStrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            String subStr = "";
            for (int j = i; j < str.length(); j++) {
                subStr += str.charAt(j);
                System.out.println(subStr);
            }
        }
    }

    public static void main(String[] args) {
        String str = "abcd";
        printSubStrings(str);
    }

}

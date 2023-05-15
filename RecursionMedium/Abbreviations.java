package RecursionMedium;

public class Abbreviations {

    // Using Position in parameter
    static void printAbbreviation(String s, String ans, int count, int position) {
        if (position == s.length()) {
            System.out.println(count == 0 ? ans : ans + count);
            return;
        }

        if (count > 0) {
            printAbbreviation(s, ans + count + s.charAt(position), 0, position + 1);
        } else {
            printAbbreviation(s, ans + s.charAt(position), 0, position + 1);
        }
        printAbbreviation(s, ans, count + 1, position + 1);
    }

    // Using first character, substring and ternary operator
    static void abbreviation(String s, String ans, int count) {
        if (s.isEmpty()) {
            System.out.println(count == 0 ? ans : ans + count);
            return;
        }

        char ch = s.charAt(0);
        abbreviation(s.substring(1), ans + (count == 0 ? "" : count) + ch, 0);
        abbreviation(s.substring(1), ans, count + 1);
    }

    public static void main(String[] args) {
//        printAbbreviation("pep", "", 0, 0);
        abbreviation("pep", "", 0);
    }

}

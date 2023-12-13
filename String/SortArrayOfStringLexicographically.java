package String;

import java.util.Arrays;

public class SortArrayOfStringLexicographically {

//    compareTo() / compareToIgnoreCase()
//    This method compares two strings lexicographically and returns
//    0 if the string is equal to the other string, ignoring case differences
//    < 0 if the string is lexicographically less than the other string
//    > 0 if the string is lexicographically greater than the other string (more characters)


    // TC - O(n^2)
    // Without inbuilt function

    // Outer loop iterates n times - O(n)
    // Inner loop iterates n times - O(n)
    // compareStrings function compares two strings character by character.
    // In the worst case, it iterates through the entire length of the shorter string. - O(min(len1, len2))

    // The time complexity of the nested loops is O(n) * O(n) = O(n^2).
    // The compareStrings function has negligible impact on the overall time complexity because its time complexity is smaller than O(n^2).
    static void sort1(String[] str) {
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length && i != j; j++) {
                if (compareStrings(str[i], str[j]) > 0) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
    }

    private static int compareStrings(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if (ch1 != ch2) {
                return ch1 - ch2;
            }
        }
        return len1 - len2;
    }


    // TC - O(n^2)
    // With inbuilt function
    static void sort2(String[] str) {
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].compareToIgnoreCase(str[j]) > 0) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
    }


    // TC - O(n log n)
    // With Sort function
    static void sort3(String[] str) {
        Arrays.sort(str, String.CASE_INSENSITIVE_ORDER);
    }


    public static void main(String[] args) {
        String[] str = {"appease", "abandon", "animal", "approval", "accenture", "appealing", "apple"};
        System.out.println(Arrays.toString(str));

        sort1(str);
        System.out.println(Arrays.toString(str));

//        sort2(str);
//        System.out.println(Arrays.toString(str));

//        sort3(str);
//        System.out.println(Arrays.toString(str));
    }

}

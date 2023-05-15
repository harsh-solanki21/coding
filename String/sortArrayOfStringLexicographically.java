package String;

import java.util.Arrays;

public class sortArrayOfStringLexicographically {

//    str[i].compareToIgnoreCase(str[j])
//    This method compares two strings lexicographically and returns
//    0 if the string is equal to the other string, ignoring case differences
//    < 0 if the string is lexicographically less than the other string
//    > 0 if the string is lexicographically greater than the other string (more characters)
    static String[] sort(String[] str) {
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].compareToIgnoreCase(str[j]) > 0) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String[] nums = {"Harit", "Girish", "Gritav", "Lovenish", "Nikhil", "Harman"};
        System.out.println(Arrays.toString(sort(nums)));
    }

}

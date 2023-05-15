package String;

import java.util.ArrayList;

public class RotationsOfEachOther {

    // Approach 1
    // TC - O(n^2), SC - O(1)
    static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int size = s1.length();
        char firstChar = s1.charAt(0);
        for (int i = 0; i < size; i++) {
            if (s2.charAt(i) == firstChar) {
                indexes.add(i);
            }
        }

        boolean isRotation = false;
        for (int i : indexes) {
            isRotation = checkString(s1, s2, i, size);
            if (isRotation) {
                break;
            }
        }

        return isRotation;
    }

    private static boolean checkString(String s1, String s2, int index, int size) {
        for (int i = 0; i < size; i++) {
            if (s1.charAt(i) != s2.charAt((index + i) % size))
                return false;
        }
        return true;
    }


    // Approach 2
    // TC - O(n), SC - O(n)
    static boolean areRotations2(String str1, String str2) {
        return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
//        return (str1.length() == str2.length()) && ((str1 + str1).contains(str2));
    }

    public static void main(String[] args) {
        String str1 = "AACD";
        String str2 = "ACDA";
        System.out.println(areRotations(str1, str2));
    }

}

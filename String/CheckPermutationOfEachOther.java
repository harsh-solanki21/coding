package String;

import java.util.Arrays;

public class CheckPermutationOfEachOther {

    // Approach 1 - Sorting
    static boolean arePermutation(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        if (n1 != n2)
            return false;

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for (int i = 0; i < n1; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }


    // Approach 2 - Count Characters
    static int NO_OF_CHARS = 256;

    static boolean arePermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[] count1 = new int[NO_OF_CHARS];
        int[] count2 = new int[NO_OF_CHARS];

        for (int i = 0; i < arr1.length; i++) {
            count1[arr1[i]]++;
            count2[arr2[i]]++;
        }

        for (int i = 0; i < NO_OF_CHARS; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }


    // Approach 3
    static boolean arePermutation3(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[] count = new int[NO_OF_CHARS];
        for (int i = 0; i < arr1[i]; i++) {
            count[arr1[i]]++;
            count[arr2[i]]--;
        }

        for (int i = 0; i < NO_OF_CHARS; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String str1 = "test";
        String str2 = "ttew";

        if (arePermutation3(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}

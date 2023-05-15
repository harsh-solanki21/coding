package RecursionMedium;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {

    // 1 - abc, 2 - def, 3 - ghi, 4 - jkl, 5 - mno, 6 - pqr, 7 - stu, 8 - vwx, 9 - yz
    // print the answer
    static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }

    }

    // add answer to the ArrayList
    static ArrayList<String> padRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2

        ArrayList<String> list = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            list.addAll(padRet(p + ch, up.substring(1)));
        }
        return list;
    }

    // Count answers
    static int padCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }
        return count;
    }


    // 0 - .;,1 - abc, 2 - def, 3 - ghi, 4 - jkl, 5 - mnop, 6 - qrst, 7 - uv, 8 - wxyz
    static String[] combinations = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz",};

    static ArrayList<String> getKeypadCombinations(String s) {
        if (s.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        char ch = s.charAt(0);
        ArrayList<String> res = getKeypadCombinations(s.substring(1));
        ArrayList<String> ans = new ArrayList<>();

        String combinationOfCh = combinations[ch - '0'];
        for (int i = 0; i < combinationOfCh.length(); i++) {
            for (String str : res) {
                ans.add(combinationOfCh.charAt(i) + str);
            }
        }
        return ans;
    }


    // print keypad combinations
    static void printKeypadCombinations(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        String strCode = combinations[ch - '0'];
        for (int i = 0; i < strCode.length(); i++) {
            printKeypadCombinations(s.substring(1), ans + strCode.charAt(i));
        }
    }


    // Leetcode Solution
    static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        backtrackPhonepad(digits.toCharArray(), res, new char[digits.length()], 0);
        return res;
    }

    private static void backtrackPhonepad(char[] digits, List<String> res, char[] temp, int start) {
        if (start == digits.length) {
            res.add(new String(temp));
            return;
        }
        int startChar = (digits[start] - '2') * 3; // the start index of each digit
        // special cases for 7, 8 and 9
        int limit = 3;
        if (digits[start] == '7' || digits[start] == '9') limit = 4;
        if (digits[start] > '7') startChar++;

        for (int j = 0; j < limit; j++) {
            temp[start] = (char) (startChar + 'a' + j);
            backtrackPhonepad(digits, res, temp, start + 1);
        }
    }


    // Driver
    public static void main(String[] args) {
//        pad("", "12");
//        System.out.println(padRet("", "12"));
//        System.out.println(padCount("", "12"));
//        System.out.println(getKeypadCombinations("678"));
//        printKeypadCombinations("678", "");
        System.out.println(letterCombinations("234"));
    }

}

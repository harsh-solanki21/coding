package String;

public class CaseSpecificSorting {

    static String caseSpecificSort(String str) {
        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowerCase[ch - 'a']++;
            } else {
                upperCase[ch - 'A']++;
            }
        }

        StringBuilder sortedStr = new StringBuilder();
        int loIndex = 0, upIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (loIndex < 26 && lowerCase[loIndex] > 0) {
                    sortedStr.append((char) ('a' + loIndex));
                    lowerCase[loIndex]--;
                } else {
                    while (loIndex < 26 && lowerCase[loIndex] == 0) {
                        loIndex++;
                    }
                    if (loIndex < 26) {
                        sortedStr.append((char) ('a' + loIndex));
                        lowerCase[loIndex]--;
                    }
                }
            } else {
                if (upIndex < 26 && upperCase[upIndex] > 0) {
                    sortedStr.append((char) ('A' + upIndex));
                    upperCase[upIndex]--;
                } else {
                    while (upIndex < 26 && upperCase[upIndex] == 0) {
                        upIndex++;
                    }
                    if (upIndex < 26) {
                        sortedStr.append((char) ('A' + upIndex));
                        upperCase[upIndex]--;
                    }
                }
            }
        }

        return sortedStr.toString();
    }


    public static void main(String[] args) {
        String str = "defRTSersUXI";
        System.out.println(caseSpecificSort(str));
    }

}

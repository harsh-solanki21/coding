package String;

public class longestCommonPrefix {

    static String longestPrefix(String[] s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (s.length > 0 && s[0].length() > i) {
            char c = s[0].charAt(i);
            for (String word : s) {
                if (word.length() <= i || word.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] str = {"flower", "flow", "flight"};
//        String[] str = {"dog", "racecar", "car"};
        String[] str = {"", "car"};
        System.out.println(longestPrefix(str));
    }

}

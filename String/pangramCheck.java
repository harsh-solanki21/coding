package String;

public class pangramCheck {

    static int pangram(String[] s) {
        int[] a = new int[26];
        for (int i = 0; i < s.length; i++) {
            String temp = s[i].toLowerCase();
            for (int j = 0; j < temp.length(); j++) {
                a[temp.charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] == 0)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        String[] str = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        System.out.println(pangram(str));
    }

}

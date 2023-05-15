package String;

public class shifyByKelements {

    static String shiftByK(String str, int k) {
        char[] s = str.toCharArray();
        char[] ans = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            int index = (i + k) % s.length;
            ans[index] = s[i];
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        String str = "hacker";
        int k = 2;
        System.out.println(shiftByK(str, k));
    }

}

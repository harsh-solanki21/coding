package String;

public class palindromicTime {

    static int getPalindromicTime(String str) {
        int hh, mm;
        hh = (str.charAt(0) - 48) * 10 + (str.charAt(1) - 48);
        mm = (str.charAt(3) - 48) * 10 + (str.charAt(4) - 48);
        int requiredTime = 0;

        while (hh % 10 != mm / 10 || hh / 10 != mm % 10) {
            mm++;
            if (mm == 60) {
                mm = 0;
                ++hh;
            }
            if (hh == 24)
                hh = 0;
            requiredTime++;
        }

        return requiredTime;
    }

    public static void main(String[] args) {
        String str = "05:39";
        System.out.println(getPalindromicTime(str));
    }

}

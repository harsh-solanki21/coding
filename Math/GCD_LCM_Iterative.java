package Math;

public class GCD_LCM_Iterative {

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 15, b = 20;
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

}

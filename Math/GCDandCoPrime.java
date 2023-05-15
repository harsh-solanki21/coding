package Math;

public class GCDandCoPrime {

    // Approach: First remove the common factors of a and b by finding gcd
    // and then divide a with the gcd

    static int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        if (a == b)
            return a;
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

    static int coprime(int a, int b) {
        while (gcd(a, b) != 1)
            a = a / gcd(a, b);
        return a;
    }

    public static void main(String[] args) {
        int a = 30;
        int b = 12;
        System.out.println(coprime(a, b));
    }

}

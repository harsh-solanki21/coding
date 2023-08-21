package Arrays;

public class PythagoreanTriplets {

    static void triplets1(int limit) {
        int a, b, c = 0;
        int m = 2;
        while (c < limit) {
            for (int n = 1; n < m; ++n) {
                a = m * m - n * n;
                b = 2 * m * n;
                c = m * m + n * n;

                if (c > limit)
                    break;
                System.out.println(a + " " + b + " " + c);
            }
            m++;
        }
    }

    static int triplets2(int limit) {
        int count = 0;
        for (int i = 0; i < limit - 1; i++) {
            for (int j = i + 1; j < limit; j++) {
                for (int k = j + 1; k < limit + 1; k++) {
                    int a = i * i;
                    int b = j * j;
                    int c = k * k;
                    if (a + b == c)
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int limit = 20;
        triplets1(limit);
        System.out.println(triplets2(limit));
    }

}

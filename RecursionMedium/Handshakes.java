package RecursionMedium;

public class Handshakes {

//    We have N persons sitting on a round table. Any person can do a handshake with any other person.
//
//            1
//       2         3
//            4
//
//    Handshake with 2-3 and 1-4 will cause cross.
//    In how many ways these N people can make handshakes so that no two handshakes cross each other. N would be even.

    static int count(int n) {
        if (n == 0) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            ans += count(i) * count(n - 2 - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(count(4));
    }

}

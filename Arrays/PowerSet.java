package Arrays;

public class PowerSet {

    // O(n * 2^n)
    static void printPowerSet(char[] set, int setSize) {
        long powSetSize = (long) Math.pow(2, setSize);
        for (int i = 0; i < powSetSize; i++) {
            for (int j = 0; j < setSize; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j]);
                }
            }
            System.out.println();
        }
    }

    // O(2^n)
    static void powerSet(String s, int i, String cur) {
        if (i == s.length()) {
            System.out.println(cur);
            return;
        }
        powerSet(s, i + 1, cur + s.charAt(i));
        powerSet(s, i + 1, cur);
    }

    public static void main(String[] args) {
//        char[] set = {'a', 'b', 'c'};
//        printPowerSet(set, 3);
        String s = "abc";
        powerSet(s, 0, "");
    }

}

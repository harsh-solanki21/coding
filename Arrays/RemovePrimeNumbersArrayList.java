package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RemovePrimeNumbersArrayList {

    // When we remove something from the list then indexes will be changed of all the values which comes after the removed value
    // So the good way to approach this kind of problem is by iterating it in reverse
    static ArrayList<Integer> removePrimes(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (isPrime(list.get(i))) {
                list.remove(i);
            }
        }
        return list;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7, 18, 3, 14, 19, 31, 72));
        System.out.println(removePrimes(list));
    }

}

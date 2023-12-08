package Arrays;

public class TransformToPrime {

//    Insert minimum number in array so that sum of array becomes prime.
//    Given an array of n integers. Find minimum number to be inserted in array,
//    so that sum of all elements of array becomes prime. If sum is already prime, then return 0.

    // TC - O(N log(log N))
    static int minNumber(int[] nums) {
        int sum = 0;
        boolean agr = false;
        for (int j : nums) {
            sum += j;
        }

        int y = sum;
        int x = sum % 2 == 0 ? sum + 1 : sum;
        while (!agr) {
            agr = isPrime(x);
            if (!agr) {
                x = x + 2;
            }
        }

        if (x == 1) {
            return 1;
        }

        return x - y;
    }

    private static boolean isPrime(int sum) {
        int c = 1;
        if (sum == 1) {
            return true;
        }

        for (int i = 3; i < Math.sqrt(sum); i = i + 2) {
            if (sum % i == 0) {
                c++;
            }
            if (c >= 2) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 12};
        System.out.println(minNumber(nums));
    }

}

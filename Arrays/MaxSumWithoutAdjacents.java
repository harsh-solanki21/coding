package Arrays;

public class MaxSumWithoutAdjacents {

    // Max Sum without Adjacents
//    Given an array Arr of size N containing positive integers.
//    Find the maximum sum of any possible subsequence such that no two numbers in the subsequence should be adjacent in Arr.
    static int findMaxSum(int[] nums) {
        int prevSum = 0;
        int currSum = 0;
        for (int i : nums) {
            int temp = Math.max(prevSum + i, currSum);
            prevSum = currSum;
            currSum = temp;
        }
        return currSum;
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 10, 100, 10, 4};
        System.out.println(findMaxSum(nums));
    }

}

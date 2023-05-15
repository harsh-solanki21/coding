package BitManipulation;

public class FindUnique {

    // Every number is appearing 2 times. Find the number that is appearing only once.
    // Brute force solution is sort the array and then find the unique one.

    public static void main(String[] args) {
        int[] nums = {2,3,3,4,2,6,4};
        System.out.println(findUnique(nums));
    }

    static int findUnique(int[] nums) {
        int unique = 0;
        for(int n : nums) {
            unique ^= n;
        }
        return unique;
    }

}

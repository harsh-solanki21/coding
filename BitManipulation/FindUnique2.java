package BitManipulation;

public class FindUnique2 {

    // Every number is appearing 3 times. Find the number that is appearing only once.
    // Solution: If the number is appearing 3 times then its set bits will appear 3 times. Hence, the set bits will be the modulo of 3.
    // And the remaining bits will be the answer. (Same applies on number appearing 5,7,... times and find the number that is appearing once)

    // Approach 1
    static int findUnique2(int[] nums) {
        int ones = 0;
        int twos = 0;
        int not_threes;
        int x;

        for (int i = 0; i < 10; i++) {
            x = nums[i];
            twos |= ones & x; // Step 1
            ones ^= x; // Step 2
            not_threes = ~(ones & twos); // Step 3
            ones &= not_threes; // Step 4
            twos &= not_threes; // Step 5
        }
        return ones;
    }

    // Approach 2
    static int findUniqueElement2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int num : nums){
                sum += num >> i & 1;
            }
            sum %= 3;
            ans |= sum << i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2, 7, 7, 8, 7, 8, 8};
        System.out.println(findUnique2(nums));
        System.out.println(findUniqueElement2(nums));
    }

}

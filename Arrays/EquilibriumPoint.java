package Arrays;

public class EquilibriumPoint {

    // Equilibrium point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

    // TC - O(n^2)
    static int equilibriumPoint1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftsum = 0, rightsum = 0;
            for (int j = 0; j < i; j++) {
                leftsum += nums[j];
            }

            for (int j = i + 1; j < nums.length; j++) {
                rightsum += nums[j];
            }

            if (leftsum == rightsum) {
                return i;
            }
        }

        return -1;
    }

    // TC - O(n), SC - O(n)
    static int equilibrium2(int[] nums) {
        if (nums.length == 1){
            return 0;
        }

        int[] front = new int[nums.length];
        int[] back = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                front[i] = front[i - 1] + nums[i];
            } else {
                front[i] = nums[i];
            }
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (i <= nums.length - 2) {
                back[i] = back[i + 1] + nums[i];
            } else {
                back[i] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (front[i] == back[i]) {
                return i;
            }
        }

        return -1;
    }

    // TC - O(n)
    static int equilibrium3(int[] nums) {
        int sum = 0, leftsum = 0;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (leftsum == sum){
                return i;
            }
            leftsum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equilibriumPoint1(nums));
        System.out.println(equilibrium2(nums));
        System.out.println(equilibrium3(nums));
    }

}

package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementOnLeft {

    static int[] nextSmallerElement(int[] nums) {
        int[] nse = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() >= nums[i]) {
                st.pop();
            }
            nse[i] = st.empty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        return nse;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerElement(nums)));
    }

}

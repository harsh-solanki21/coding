package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementOnRight {

    // Approach 1
    static int[] nextGreaterElement(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= nums[i]) {
                st.pop();
            }
            nge[i] = st.empty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        return nge;
    }


    // Approach 2
    static int[] nextGreaterElement2(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for (int i = 1; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                int position = st.peek();
                nge[position] = nums[i];
                st.pop();
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            int position = st.peek();
            nge[position] = -1;
            st.pop();
        }

        return nge;
    }


    public static void main(String[] args) {
        int[] nums = {7, 12, 3, 5, 18, 8, 9, 4, 6, 10};
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
        System.out.println(Arrays.toString(nextGreaterElement2(nums)));
    }

}

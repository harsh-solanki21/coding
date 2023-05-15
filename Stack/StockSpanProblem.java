package Stack;

import java.util.Stack;
import java.util.Arrays;

public class StockSpanProblem {

    static int[] stockSpan(int[] nums) {
        int[] span = new int[nums.length];

        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            while (!st.empty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            span[i] = (st.empty()) ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] price = {10, 4, 5, 90, 120, 80};
        System.out.print(Arrays.toString(stockSpan(price)));
    }

}

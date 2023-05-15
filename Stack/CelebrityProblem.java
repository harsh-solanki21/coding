package Stack;

import java.util.Stack;

public class CelebrityProblem {

    // There cannot be 2 celebrities. If there is a celebrity then there will be only 1 celebrity.
    // It is possible that there is no celebrity.

    static void findCelebrity(int[][] nums) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();
            if (nums[i][j] == 1) // if i knows j, then i is not a celebrity
                st.push(j);
            else  // if i doesn't know j, then j is not a celebrity
                st.push(i);
        }

        int pot = st.pop();  // potential ans
        for (int i = 0; i < nums.length; i++) {
            if (i != pot) {
                if (nums[i][pot] == 0 || nums[pot][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }

        System.out.println(pot);
    }

    public static void main(String[] args) {
        int[][] nums = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0}
        };
        findCelebrity(nums);
    }

}

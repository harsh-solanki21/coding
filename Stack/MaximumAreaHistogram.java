package Stack;

import java.util.Stack;

public class MaximumAreaHistogram {

    // Approach 1
    static int largestAreaHistogram(int[] hist) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int top;
        int areaWithTop;
        int i = 0;

        while (i < hist.length) {
            if (s.empty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                top = s.peek();
                s.pop();
                areaWithTop = hist[top] * (s.empty() ? i : i - s.peek() - 1);

                if (maxArea < areaWithTop) {
                    maxArea = areaWithTop;
                }
            }
        }

        while (!s.empty()) {
            top = s.peek();
            s.pop();
            areaWithTop = hist[top] * (s.empty() ? i : i - s.peek() - 1);

            if (maxArea < areaWithTop) {
                maxArea = areaWithTop;
            }
        }

        return maxArea;
    }


    // Approach 2
    static int largestAreaHistogram2(int[] hist) {
        int[] rb = new int[hist.length];  // next smaller index on the right
        Stack<Integer> st = new Stack<>();
        st.push(hist.length - 1);
        rb[hist.length - 1] = hist.length;

        for (int i = hist.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && hist[i] < hist[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0)
                rb[i] = hist.length;
            else
                rb[i] = st.peek();

            st.push(i);

        }

        int[] lb = new int[hist.length];  // next smaller index on the left
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;

        for (int i = 1; i < hist.length; i++) {
            while (!st.isEmpty() && hist[i] < hist[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0)
                lb[i] = -1;
            else
                lb[i] = st.peek();

            st.push(i);

        }


        int maxArea = 0;
        for (int i = 0; i < hist.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = hist[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int[] hist = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestAreaHistogram(hist));
        System.out.println(largestAreaHistogram2(hist));
    }

}

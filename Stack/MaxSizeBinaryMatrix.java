package Stack;

import java.util.Stack;

public class MaxSizeBinaryMatrix {

    // Maximum Size rectangle area in binary sub matrix
    // TC - O(R * C), SC - O(C)
    static int maxHistogram(int R, int C, int[] row) {
        Stack<Integer> result = new Stack<>();

        int topVal;
        int maxArea = 0, area = 0;

        int i = 0;
        while (i < C) {
            if (result.empty() || row[result.peek()] <= row[i]) {
                result.push(i++);
            } else {
                topVal = row[result.peek()];
                result.pop();
                area = topVal * i;

                if (!result.empty()) {
                    area = topVal * (i - result.peek() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!result.empty()) {
            topVal = row[result.peek()];
            result.pop();
            area = topVal * i;

            if (!result.empty()) {
                area = topVal * (i - result.peek() - 1);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }


    static int maxRectangle(int R, int C, int[][] A) {
        int result = maxHistogram(R, C, A[0]);
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == 1) {
                    A[i][j] += A[i - 1][j];
                }
            }
            result = Math.max(result, maxHistogram(R, C, A[i]));
        }

        return result;
    }


    public static void main(String[] args) {
        int R = 4;
        int C = 4;

        int[][] A = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.print("Area of maximum rectangle: " + maxRectangle(R, C, A));
    }

}

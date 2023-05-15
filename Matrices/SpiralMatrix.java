package Matrices;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    static List<Integer> spiralOrder(int[][] matrix) {
        int size = matrix.length * matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom) {
            int temp = top;
            while (temp <= right && list.size() < size)
                list.add(matrix[top][temp++]);
            temp = ++top;

            while (temp <= bottom && list.size() < size)
                list.add(matrix[temp++][right]);
            temp = --right;

            while (temp >= left && list.size() < size)
                list.add(matrix[bottom][temp--]);
            temp = --bottom;

            while (temp >= top && list.size() < size)
                list.add(matrix[temp--][left]);
            ++left;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }

}

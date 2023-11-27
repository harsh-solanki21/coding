package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    // to get array of the specific row only
    static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long val = 1;
        for (int j = 0; j <= rowIndex; j++) {
            ans.add((int) val);
            val = val * (rowIndex - j) / (j + 1);
        }
        return ans;
    }

    static ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> pre = new ArrayList<>();
        long mod = 1000000007;
        for (int i = 0; i < n; i++) {
            ArrayList<Long> current = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == i | j == 0) {
                    current.add(1l);
                } else {
                    long num = (pre.get(j) + pre.get(j - 1)) % mod;
                    current.add(num);
                }
            }
            pre = current;
        }
        return pre;
    }


    // to get array of all the rows till specified row
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));
        System.out.println(nthRowOfPascalTriangle(rowIndex));
        System.out.println(generate(rowIndex));
    }

}

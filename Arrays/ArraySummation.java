package Arrays;

import java.util.Arrays;

public class ArraySummation {

    static int[] addArrays(int[] a1, int[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        int[] sum = new int[n1 > n2 ? n1 : n2];

        int i = n1 - 1;
        int j = n2 - 1;
        int k = sum.length - 1;
        int carry = 0;

        while (k >= 0) {
            int c = carry;
            if (i >= 0) {
                c += a1[i];
            }
            if (j >= 0) {
                c += a2[j];
            }
            carry = c / 10;
            c = c % 10;
            sum[k] = c;
            i--;
            j--;
            k--;
        }

        if (carry != 0) {
            int[] ans = new int[(n1 > n2 ? n1 : n2) + 1];
            ans[0] = carry;
            for (i = 0; i < ans.length - 1; i++)
                ans[i + 1] = sum[i];
            return ans;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a1 = {2, 1, 8, 9, 5};
        int[] a2 = {6, 7, 6, 7, 4, 1, 3, 0, 1, 8};
        System.out.println(Arrays.toString(addArrays(a1, a2)));
    }

}

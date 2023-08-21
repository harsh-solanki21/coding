package Arrays;

import java.util.Arrays;

public class FindOriginalArray {

    // https://leetcode.com/problems/find-original-array-from-doubled-array/

    static int[] findOriginalArray(int[] changed) {
        // if odd number of elements then can't make original array
        if (changed.length % 2 != 0) {
            return new int[0];
        }

        int max = 0;
        for (int i : changed) {
            max = Math.max(max, i);
        }

        // freq can be upto max * 2 + 1 only
        int[] freq = new int[max * 2 + 1];
        for (int i : changed) {
            freq[i]++;
        }

        int[] ans = new int[changed.length / 2];
        int index = 0;

        for (int i = 0; i <= max; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                int twice = i * 2;
                if (freq[twice] > 0) {
                    freq[twice]--;
                    ans[index++] = i;
                    i--;
                } else {
                    return new int[0];
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 6, 8};
        System.out.println(Arrays.toString(findOriginalArray(nums)));
    }

}

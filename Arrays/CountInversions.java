package Arrays;

public class CountInversions {

    // Brute force = TC - O(n^2)
    static int inversionCount(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    // Merge Sort = TC - O(n logn), SC - O(n)
    private static int merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        int invCount = 0;
        int[] temp = new int[(right - left + 1)];

        while ((i < mid) && (j <= right)) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                ++k;
                ++i;
            } else {
                temp[k] = nums[j];
                invCount += (mid - i);
                ++k;
                ++j;
            }
        }

        while (i < mid) {
            temp[k] = nums[i];
            ++k;
            ++i;
        }

        while (j <= right) {
            temp[k] = nums[j];
            ++k;
            ++j;
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            nums[i] = temp[k];
        }

        return invCount;
    }

    private static int mergeSort(int[] nums, int left, int right) {
        int invCount = 0;
        if (right > left) {
            int mid = (right + left) / 2;
            invCount = mergeSort(nums, left, mid);
            invCount += mergeSort(nums, mid + 1, right);
            invCount += merge(nums, left, mid + 1, right);
        }
        return invCount;
    }

    public static int getInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(nums));
        System.out.println(getInversions(nums));
    }

}

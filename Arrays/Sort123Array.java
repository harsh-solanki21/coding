package Arrays;

public class Sort123Array {

    static void sort123(int[] nums) {
        int start = 0, end = nums.length-1;
        int mid = 0;
        while(mid <= end) {
            switch (nums[mid]) {
                case 0:
                    int temp = nums[start];
                    nums[start] = nums[mid];
                    nums[mid] = temp;
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = nums[mid];
                    nums[mid] = nums[end];
                    nums[end] = temp;
                    end--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort123(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }

}

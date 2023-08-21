package Arrays;

public class ThirdMaximumNumber {

    static int thirdMax(int[] nums) {
        int largest = 0, secondLargest = -1, thirdLargest = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[largest]) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = i;
            }
            else if (nums[i] != nums[largest]) {
                if (secondLargest == -1 || nums[i] > nums[secondLargest]) {
                    thirdLargest = secondLargest;
                    secondLargest = i;
                }
                else if (nums[i] != nums[secondLargest]) {
                    if (thirdLargest == -1 || nums[i] > nums[thirdLargest])
                        thirdLargest = i;
                }
            }
        }
        return thirdLargest == -1 ? nums[largest] : nums[thirdLargest];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }

}

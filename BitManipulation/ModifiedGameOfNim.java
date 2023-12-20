package BitManipulation;

public class ModifiedGameOfNim {

//    You are given an array A of n elements. There are two players player 1 and player 2.
//    A player can choose any of element from an array and remove it.
//    If the bitwise XOR of all remaining elements equals 0 after removal of the selected element, then that player loses.
//    Find out the winner if player 1 starts the game and they both play their best.

    static int findWinner(int[] nums) {
        if (nums.length % 2 == 0) {
            return 1;
        }

        int val = 0;
        for (int i : nums) {
            val = val ^ i;
        }

        if (val == 0) {
            return 1;
        }

        return 2;
    }

}

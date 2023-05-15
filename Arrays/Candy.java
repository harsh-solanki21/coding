package Arrays;

public class Candy {

//    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
//
//    You are giving candies to these children subjected to the following requirements:
//    - Each child must have at least one candy.
//    - Children with a higher rating get more candies than their neighbors.
//
//    Return the minimum number of candies you need to have to distribute the candies to the children.

    static int candy(int[] ratings) {
        int n = ratings.length;
        int candy = n, i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            // For increasing slope
            int peak = 0;
            while (ratings[i] > ratings[i - 1]) {
                peak++;
                candy += peak;
                i++;
                if (i == n)
                    return candy;
            }

            // For decreasing slope
            int valley = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                valley++;
                candy += valley;
                i++;
            }

            candy -= Math.min(peak, valley); // Keep only the higher peak
        }

        return candy;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

}
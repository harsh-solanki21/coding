package Arrays;

public class StockBuySellToMaximiseProfit {

//    The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
//    For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
//    the maximum profit can earn by buying on day 0, selling on day 3.
//    Again, buy on day 4 and sell on day 6.
//    If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.

    static int maxProfitMultipleBuyAndSell(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }


    static int maxProfitSingleBuyAndSell(int[] prices) {
        int maxPrice = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                maxPrice = Math.max(maxPrice, prices[i] - minPrice);
            }
        }
        return maxPrice;
    }


    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 14};
        System.out.println(maxProfitMultipleBuyAndSell(price));
        System.out.println(maxProfitSingleBuyAndSell(price));
    }

}

package DP;

public class MaxProfitStocks {

//    An investor has saved some money and wants to invest in the stock market.
//    There are a number of stocks to choose from, and they want to buy at most 1 share in any company.
//    The total invested cannot exceed the funds available.
//    A friend who is a stock market expert has predicted the values of each stock after 1 year.
//    Determine the maximum profit that can be earned at the end of the year assuming the predictions come true.
//
//    Example:-
//    saving = 250
//    currentValue = [175, 133, 109, 210, 97]
//    futureValue = [200, 125, 128, 228, 133)
//
//    To maximize profits, the investor should buy stocks at indices 2 and 4 for an investment of 109 +97 = 206.
//    At the end of the year the stocks are sold for 128 + 133 = 261, so total profit is 261 -206 = 55
//
//    Function Description:
//    Complete the function selectStock in the editor below.
//    The function should return an integer that denotes the maximum profit after one year.
//
//    selectStock has the following parameter(s):
//    int saving: amount available for investment
//    int currentValue[n]: the current stock values
//    int futureValue[n]: the values of the stocks after one year
//
//    Constraints:
//    0 < n < 100
//    0 < Savings < 30000
//    0 <= currrentValue[i], futureValuel[i] <= 300


    static int maxProfit(int[] currentValue, int[] futureValue, int saving) {
        int[][] dp = new int[currentValue.length + 1][saving + 1];
        int profit = Integer.MIN_VALUE;

        for (int i = 1; i <= currentValue.length; i++) {
            for (int j = 1; j <= saving; j++) {
                if (j < currentValue[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - currentValue[i - 1]] + (futureValue[i - 1] - currentValue[i - 1])));
                }
                profit = Math.max(profit, dp[i][j]);
            }
        }

        return profit;
    }


    public static void main(String[] args) {
        int[] currentValue = {175, 133, 109, 210, 97};
        int[] futureValue = {200, 125, 128, 228, 133};
        int saving = 250;

        System.out.println(maxProfit(currentValue, futureValue, saving));
    }

}

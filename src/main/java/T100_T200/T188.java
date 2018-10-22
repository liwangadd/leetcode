package T100_T200;

public class T188 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) return 0;
        if (k >= prices.length / 2) return quickSolve(prices);

        int[][] dp = new int[k + 1][prices.length];
        for (int i = 0; i < dp[0].length; ++i) dp[0][i] = 0;
        for (int i = 1; i <= k; ++i) {
            int tmpMax = dp[i - 1][0] - prices[0];
            for (int j = 0; j < prices.length; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], tmpMax + prices[j]);
                tmpMax = Math.max(tmpMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }

}

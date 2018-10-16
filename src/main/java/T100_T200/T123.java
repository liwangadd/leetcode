package T100_T200;

public class T123 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[3][prices.length];
        for (int i = 0; i < prices.length; ++i) dp[0][i] = 0;
        int maxProfit = 0;
        for (int i = 1; i <= 2; ++i) {
            int tmpMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(dp[i - 1][j] - prices[j], tmpMax);
                maxProfit = Math.max(dp[i][j], maxProfit);
            }
        }
        return maxProfit;
    }

}

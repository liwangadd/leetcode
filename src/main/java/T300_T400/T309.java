package T300_T400;

public class T309 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[1], buy[0]);

        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] + buy[0]);

        for (int i = 2; i < prices.length; ++i) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return Math.max(sell[prices.length - 2], sell[prices.length - 1]);
    }

}

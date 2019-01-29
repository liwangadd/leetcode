package leetcode.T100_T200;

public class T121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < min) min = prices[i];
            else profit = Math.min(profit, prices[i] - min);
        }
        return profit;
    }

}

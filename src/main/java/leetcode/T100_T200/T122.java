package leetcode.T100_T200;

public class T122 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length - 1; ++i) {
            if(prices[i]<min){
                min = prices[i];
            }else if (prices[i + 1] < prices[i]) {
                profit += (prices[i] - min);
                min = prices[i + 1];
            }
        }
        if (prices[prices.length - 1] >= prices[prices.length - 2]) {
            profit += prices[prices.length - 1] - min;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}

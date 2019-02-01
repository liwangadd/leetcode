package leetcode.T200_T300;

public class T256 {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int[][] dp = new int[costs.length + 1][3];
        for (int i = 0; i <= costs.length; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];
        }
        int len = costs.length;
        return Math.min(dp[len][0], Math.min(dp[len][1], dp[len][2]));
    }

}

package leetcode;

public class T1335 {

    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if (len < d) return -1;
        int[][] dp = new int[d][len];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < len; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);
        }
        for (int i = 1; i < d; ++i) {
            for (int j = i; j < len; ++j) {
                int localMax = jobDifficulty[j];
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = j; k >= i; --k) {
                    localMax = Math.max(localMax, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + localMax);
                }
            }
        }
        return dp[d - 1][len - 1];
    }

}

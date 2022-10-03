package leetcode;

public class T1155 {

    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[target + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                for (int roll = 1; i - roll >= 0 && roll <= k; roll++) {
                    dp[i][j] += dp[i - roll][j - 1];
                }
                dp[i][j] = dp[i][j] % MOD;
            }
        }
        return (int)dp[target][n];
    }

}

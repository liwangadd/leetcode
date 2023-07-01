package leetcode.T1200_T1300;

public class T1220 {

    private static final long MOD = (long) 1e9 + 7;

    public int countVowelPermutation(int n) {
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i + 1][0] = (dp[i][1] + dp[i][2] + dp[i][4]) % MOD;
            dp[i + 1][1] = (dp[i][0] + dp[i][2]) % MOD;
            dp[i + 1][2] = (dp[i][1] + dp[i][3]) % MOD;
            dp[i + 1][3] = dp[i][2];
            dp[i + 1][4] = (dp[i][2] + dp[i][3]) % MOD;
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (dp[n][i] + ans) % MOD;
        }
        return (int) ans;
    }

}

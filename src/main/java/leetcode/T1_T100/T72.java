package leetcode.T1_T100;

public class T72 {

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int cost = 0;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) dp[i][0] = i;
        for (int i = 0; i <= m; ++i) dp[0][i] = i;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                int min1 = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                dp[i][j] = Math.min(min1, dp[i - 1][j - 1] + cost);
            }
        }
        return dp[n][m];
    }
}

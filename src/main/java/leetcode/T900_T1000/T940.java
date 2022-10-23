package leetcode.T900_T1000;

import com.sun.deploy.security.MacOSXDeployNTLMAuthCallback;

public class T940 {

    private static final int MOD = (int) (1e9 + 7);

    public int distinctSubseqII(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][26];
        for (int i = 1; i <= len; ++i) {
            char c = s.charAt(i - 1);
            for (int j = 0; j < 26; ++j) {
                if (j + 'a' != c) dp[i][j] = dp[i - 1][j];
                else {
                    int cnt = 1;
                    for (int k = 0; k < 26; ++k) {
                        cnt = (cnt + dp[i - 1][k]) % MOD;
                    }
                    dp[i][j] = cnt;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            cnt = (cnt + dp[len][i]) % MOD;
        }
        return cnt;
    }

}

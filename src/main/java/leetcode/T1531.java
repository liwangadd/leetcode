package leetcode;

import java.util.Arrays;

public class T1531 {

    public int getLengthOfOptimalCompression(String s, int k) {
        int len = s.length();
        int[][] dp = new int[len + 1][k + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, len);
        dp[0][0] = 0;
        char[] sArr = s.toCharArray();
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j <= k; ++j) {
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                int cnt = 0, del = 0;
                for (int l = i; l > 0; --l) {
                    if (sArr[l - 1] == sArr[i - 1]) ++cnt;
                    else ++del;
                    if (j - del >= 0)
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1 : 0));
                    else break;
                }
            }
        }
        return dp[len][k];
    }

}

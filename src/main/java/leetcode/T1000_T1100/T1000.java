package leetcode.T1000_T1100;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;

public class T1000 {

    private int[][][] dp;

    private int[] prefixSum;

    private int k;

    public int mergeStones(int[] stones, int k) {
        this.k = k;
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) return -1;
        this.prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[0] + stones[i];
        }
        this.dp = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0, n - 1, 1);
    }

    private int helper(int i, int j, int t) {
        if (dp[i][j][t] != -1) return dp[i][j][t];
        if (t == 1) {
            return dp[i][j][t] = i == j ? 0 : helper(i, j, k) + prefixSum[j + 1] - prefixSum[i];
        }
        int res = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) {
            res = Math.min(res, helper(i, m, 1) + helper(m + 1, j, t - 1));
        }
        return dp[i][j][t] = res;
    }


//    public int mergeStones(int[] stones, int k) {
//        int n = stones.length;
//        if ((n - 1) % (k - 1) > 0) return -1;
//
//        int[] prefix = new int[n + 1];
//        for (int i = 0; i < n; i++)
//            prefix[i + 1] = prefix[i] + stones[i];
//
//        int[][] dp = new int[n][n];
//        for (int m = k; m <= n; ++m)
//            for (int i = 0; i + m <= n; ++i) {
//                int j = i + m - 1;
//                dp[i][j] = Integer.MAX_VALUE;
//                for (int mid = i; mid < j; mid += k - 1)
//                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
//                if ((j - i) % (k - 1) == 0)
//                    dp[i][j] += prefix[j + 1] - prefix[i];
//            }
//        return dp[0][n - 1];
//    }

}

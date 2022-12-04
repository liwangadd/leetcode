package leetcode.T800_T900;

public class T813 {

    public double largestSumOfAverages(int[] nums, int k) {
        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[][] dp = new double[k + 1][nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[1][i] = prefix[i] / i;
        }
        for (int c = 2; c <= k; ++c) {
            for (int i = c; i <= nums.length; ++i) {
                for (int j = c - 1; j < i; ++j) {
                    dp[c][i] = Math.max(dp[c][i], (dp[c - 1][j] + prefix[i] - prefix[j]) / (i - j));
                }
            }
        }
        return dp[k][nums.length];
    }

}

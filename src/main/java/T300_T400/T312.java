package T300_T400;

public class T312 {

    public int maxCoins(int[] nums) {
        int[] iNums = new int[nums.length + 2];
        System.arraycopy(nums, 0, iNums, 1, nums.length);
        iNums[0] = 1;
        iNums[iNums.length - 1] = 1;

        int[][] dp = new int[iNums.length][iNums.length];
        for (int k = 2; k < iNums.length; ++k) {
            for (int left = 0; left < iNums.length - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max(dp[left][right],
                            iNums[left] * iNums[i] * iNums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][iNums.length - 1];
    }

}

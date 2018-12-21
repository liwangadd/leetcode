package leetcode.T400_T500;

public class T416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int middle = sum / 2;
        boolean[] dp = new boolean[middle + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = middle; j >= nums[i]; --j) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[middle];
    }

}

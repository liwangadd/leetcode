public class T213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robSub(nums, 0, nums.length - 1), robSub(nums, 1, nums.length));
    }

    private int robSub(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        dp[start] = 0;
        dp[start + 1] = nums[start];
        for (int i = start + 2; i <= end; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[end];
    }

}

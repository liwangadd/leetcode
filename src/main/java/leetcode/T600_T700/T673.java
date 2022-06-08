package leetcode.T600_T700;

public class T673 {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length], counts = new int[nums.length];
        dp[0] = 1;
        counts[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            counts[i] = 1;
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) counts[i] += counts[j];
                    else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }
        }
        int maxLength = 1, count = dp[0];
        for (int i = 1; i < nums.length; ++i) {
            if (dp[i] > maxLength) {
                count = counts[i];
                maxLength = dp[i];
            } else if (dp[i] == maxLength) count += counts[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int res = new T673().findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2});
        System.out.println(res);
    }

}

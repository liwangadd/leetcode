package leetcode.T200_T300;

import java.util.Arrays;

public class T300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxVal = 1;
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (maxVal < dp[i]) maxVal = dp[i];
        }
        return maxVal;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = nums.length, monoLen = 0;
        int[] mono = new int[len];
        for (int num : nums) {
            int left = 0, right = monoLen;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mono[mid] == num) {
                    left = mid;
                    break;
                } else if (mono[mid] < num) left = mid + 1;
                else right = mid;
            }
            if (left == monoLen) ++monoLen;
            mono[left] = num;
        }
        return monoLen;
    }

    public static void main(String[] args) {
        new T300().lengthOfLIS2(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12});
    }
}

package leetcode.T700_T800;

import com.sun.xml.internal.ws.api.model.MEP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T740 {

    public int deleteAndEarn(int[] nums) {
        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int[] dp = new int[sum.length + 1];
        dp[0] = 0;
        dp[1] = sum[0];
        for (int i = 2; i <= sum.length; ++i) {
            dp[i] = Math.max(dp[i - 2] + sum[i - 1], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

}

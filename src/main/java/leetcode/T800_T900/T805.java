package leetcode.T800_T900;

import java.util.HashSet;
import java.util.Set;

public class T805 {

    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) return false;
        int len = nums.length, midLen = len / 2;
        int sum = 0;
        for (int num : nums) sum += num;
        boolean isPossible = false;
        for (int i = 1; i <= midLen; ++i) {
            if ((sum * i) % len == 0) {
                isPossible = true;
                break;
            }
        }
        if (!isPossible) return false;
        Set<Integer>[] dp = new Set[midLen + 1];
        for (int i = 0; i <= midLen; ++i) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(0);
        for (int num : nums) {
            for (int i = midLen; i >= 1; --i) {
                for (Integer preSum : dp[i - 1]) {
                    int curSum = preSum + num;
                    if (sum * i == curSum * len) return true;
                    dp[i].add(curSum);
                }
            }
        }
        return false;
    }

}

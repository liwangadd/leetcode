package leetcode;

import java.util.Arrays;

public class T1498 {

    private static final int MOD = (int) (1e9 + 7);

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] pows = new int[len + 1];
        pows[0] = 1;
        for (int i = 1; i <= len; i++) pows[i] = (pows[i - 1] * 2) % MOD;
        int left = 0, right = len - 1, res = 0;
        while (left <= right) {
            if (nums[left] + nums[right] > target) --right;
            else {
                res = (res + pows[right - left]) % MOD;
                ++left;
            }
        }
        return res;
    }

}

package leetcode;

public class T1493 {

    public int longestSubarray(int[] nums) {
        if (nums.length == 1) return 0;
        int left = 0, right = 0, zeroCount = 0, res = 0;
        while (right < nums.length) {
            if (nums[right++] == 0) ++zeroCount;
            while (zeroCount > 1) {
                if (nums[left++] == 0) --zeroCount;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}

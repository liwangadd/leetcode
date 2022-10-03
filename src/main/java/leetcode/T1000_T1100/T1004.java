package leetcode.T1000_T1100;

public class T1004 {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, res = 0, zeroCount = 0;
        while (right < nums.length) {
            if (nums[right++] == 0) ++zeroCount;
            while (zeroCount > k) {
                if (nums[left] == 0) --zeroCount;
                ++left;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}

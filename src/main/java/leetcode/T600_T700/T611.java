package leetcode.T600_T700;

import java.util.Arrays;

public class T611 {

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i > 1; --i) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return res;
    }

}

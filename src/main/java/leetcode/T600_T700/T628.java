package leetcode.T600_T700;

import java.awt.font.NumericShaper;
import java.util.Arrays;

public class T628 {

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3],
                nums[0] * nums[1] * nums[len - 1]);
    }

}

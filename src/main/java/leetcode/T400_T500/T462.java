package leetcode.T400_T500;

import java.util.Arrays;

public class T462 {

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = nums.length - 1;
        Arrays.sort(nums);
        int res = 0;
        while (i < j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }

}

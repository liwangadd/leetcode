package leetcode.T500_T600;

import java.awt.font.NumericShaper;
import java.util.Arrays;

public class T561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

}

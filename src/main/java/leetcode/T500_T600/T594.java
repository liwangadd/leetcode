package leetcode.T500_T600;

import java.awt.font.NumericShaper;
import java.util.Arrays;

public class T594 {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, left = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] - nums[left] > 1) {
                while (left <= i && nums[i] - nums[left] > 1) {
                    ++left;
                }
            } else if (nums[i] - nums[left] == 1) {
                res = Math.max(res, i - left + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T594().findLHS(new int[]{1, 1, 1, 1}));
    }

}

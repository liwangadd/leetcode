package leetcode.T100_T200;

import java.util.Arrays;

public class T169 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == res) ++count;
            else --count;
            if (count < 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T169 solution = new T169();
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}

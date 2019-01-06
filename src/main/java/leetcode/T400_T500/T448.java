package leetcode.T400_T500;

import java.util.ArrayList;
import java.util.List;

public class T448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (nums[i] >= 0) res.add(i + 1);
        }
        return res;
    }

}

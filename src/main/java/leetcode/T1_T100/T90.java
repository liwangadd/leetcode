package leetcode.T1_T100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90 {

    private List<List<Integer>> res;
    private boolean[] flags;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        flags = new boolean[nums.length];
        Arrays.sort(nums);
        search(nums, 0);
        return res;
    }

    private void search(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < flags.length; ++i) {
                if (flags[i]) item.add(nums[i]);
            }
            res.add(item);
            return;
        }
        search(nums, index + 1);
        if (index == 0 || nums[index - 1] != nums[index] || flags[index - 1]) {
            flags[index] = true;
            search(nums, index + 1);
            flags[index] = false;
        }
    }

}

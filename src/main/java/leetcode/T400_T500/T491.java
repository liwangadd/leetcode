package leetcode.T400_T500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) return res;
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> resItem) {
        if (resItem.size() > 1) {
            res.add(new ArrayList<>(resItem));
        }
        if (pos == nums.length) return;
        Set<Integer> used = new HashSet<>();
        for (int i = pos; i < nums.length; ++i) {
            if(used.contains(nums[i])) continue;
            if (resItem.size() == 0 || nums[i] >= resItem.get(resItem.size() - 1)) {
                resItem.add(nums[i]);
                used.add(nums[i]);
                helper(nums, i + 1, res, resItem);
                resItem.remove(resItem.size() - 1);
            }
        }
    }

}

package leetcode.T1_T100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) return res;
        boolean[] flag = new boolean[candidates.length];
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, res, new LinkedList<>());
        return res;
    }

    public void combinationSum2(int[] candidates, int target,
                                int index, List<List<Integer>> res, List<Integer> item) {
        if (target == 0) {
            List<Integer> resItem = new ArrayList<>(item);
            res.add(resItem);
            return;
        }
        if (target < 0) return;
        for (int i = index; i < candidates.length; ++i) {
            item.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, res, item);
            item.remove(item.size() - 1);
            while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
                ++i;
            }
        }
    }

}

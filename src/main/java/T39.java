import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> resItem = new LinkedList<>();
        combinationSum(candidates, target, res, resItem, 0);
        return res;
    }

    public void combinationSum(int[] candidates, int target, List<List<Integer>> res, List<Integer> item, int start) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>(item.size());
            list.addAll(item);
            res.add(list);
            return;
        }
        if (target < 0) return;
        for (int i = start; i < candidates.length; ++i) {
            item.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], res, item, i);
            item.remove(item.size() - 1);
        }
    }

}

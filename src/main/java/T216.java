import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        combinationSum3(1, k, n, res, new LinkedList<>());
        return res;
    }

    private <E> void combinationSum3(int start, int k, int n, List<List<Integer>> res, LinkedList<Integer> resItem) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(resItem));
            return;
        }
        if (n < 0 || k == 0) return;
        for (int i = start; i < 10 - k + 1; ++i) {
            resItem.add(i);
            combinationSum3(i + 1, k - 1, n - i, res, resItem);
            resItem.remove(resItem.size() - 1);
        }
    }

}

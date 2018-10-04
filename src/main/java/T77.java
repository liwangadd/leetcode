import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (n < 1) return res;
        combine(1, n, k, res, new LinkedList<>());
        return res;
    }

    private void combine(int start, int end, int k, List<List<Integer>> res, List<Integer> resItem) {
        if (k == 0) {
            res.add(new ArrayList<>(resItem));
            return;
        }
        if (start > end) return;
        for (int i = start; i <= end - k + 1; ++i) {
            resItem.add(i);
            combine(i + 1, end, k - 1, res, resItem);
            resItem.remove(resItem.size() - 1);
        }
    }

}

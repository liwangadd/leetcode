import java.util.ArrayList;
import java.util.List;

public class T118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        List<Integer> firstItem = new ArrayList<>();
        firstItem.add(1);
        res.add(firstItem);
        for (int i = 1; i < numRows; ++i) {
            List<Integer> item = new ArrayList<>();
            item.add(1);
            List<Integer> lastItem = res.get(i - 1);
            for (int j = 0; j < lastItem.size() - 1; ++j) {
                item.add(lastItem.get(j) + lastItem.get(j + 1));
            }
            item.add(1);
            res.add(item);
        }
        return res;
    }

}

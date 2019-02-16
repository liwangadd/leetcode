package leetcode.T200_T300;

import java.util.ArrayList;
import java.util.List;

public class T254 {

    private List<List<Integer>> res;

    public List<List<Integer>> getFactors(int n) {
        res = new ArrayList<>();
        helper(n, 2, new ArrayList<>());
        return res;
    }

    private void helper(int n, int factor, ArrayList<Integer> vec) {
        if (factor > Math.sqrt(n)) return;
        helper(n, factor + 1, vec);
        if (n % factor == 0) {
            vec.add(factor);
            helper(n / factor, factor, vec);
            vec.add(n / factor);
            res.add(new ArrayList<>(vec));
            vec.remove(vec.size()-1);
            vec.remove(vec.size()-1);
        }
    }

}

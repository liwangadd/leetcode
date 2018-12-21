package leetcode.T100_T200;

import java.util.LinkedList;
import java.util.List;

public class T163 {

    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> res = new LinkedList<>();
        if (lower == upper) return res;
        for (int aA : A) {
            if (aA - 2 > lower) {
                res.add(lower + 1 + "->" + (aA - 1));
            } else if (aA - 1 > lower) {
                res.add(lower + 1 + "");
            }
            lower = aA;
        }
        if (upper - 2 > lower) {
            res.add(lower + 1 + " " + (upper - 1));
        } else if (upper - 1 > lower) {
            res.add(lower + 1 + "");
        }
        return res;
    }
}

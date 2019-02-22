package leetcode.T100_T200;

import java.util.LinkedList;
import java.util.List;

public class T163 {

    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> res = new LinkedList<>();
        if(A.length == 0){
            if(upper > lower){
                res.add(lower + "->" + upper);
            }else{
                res.add(lower + "");
            }
            return res;
        }
        for (int aA : A) {
            if (aA - 1 > lower) {
                res.add(lower + "->" + (aA - 1));
            } else if (aA > lower) {
                res.add(lower + "");
            }
            lower = aA + 1;
        }
        if (upper > lower) {
            res.add(lower + "->" + (upper));
        } else if(upper == lower) {
            res.add(upper + "");
        }
        return res;
    }
}

package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T2718 {

    public List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) == 1) return Collections.emptyList();
        LinkedList<Long> res = new LinkedList<>();
        long pos = 2, sum = 0;
        for (; sum < finalSum; pos += 2) {
            res.add(pos);
            sum += pos;
        }
        if (sum > finalSum) {
            res.remove(sum - finalSum);
        }
        return res;
    }

}

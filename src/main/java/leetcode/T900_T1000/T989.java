package leetcode.T900_T1000;

import java.util.LinkedList;
import java.util.List;

public class T989 {

    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int pos = num.length - 1, carried = 0;
        for (; pos >= 0 || k > 0; --pos, k /= 10) {
            int a = 0, b = k % 10;
            if (pos >= 0) a = num[pos];
            int sum = a + b + carried;
            res.addFirst(sum % 10);
            carried = sum / 10;
        }
        if (carried > 0) res.addFirst(carried);
        return res;
    }

}

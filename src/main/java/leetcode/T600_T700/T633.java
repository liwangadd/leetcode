package leetcode.T600_T700;

import java.util.HashSet;
import java.util.Set;

public class T633 {

    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        for (int i = 0; i * i <= c; ++i) {
            int res = c - i * i;
            int sqrt = (int) Math.sqrt(res);
            if (sqrt * sqrt == res) return true;
        }
        return false;
    }

}

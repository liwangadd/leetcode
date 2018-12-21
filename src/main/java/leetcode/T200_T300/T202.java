package leetcode.T200_T300;

import java.util.HashSet;
import java.util.Set;

public class T202 {

    public boolean isHappy(int n) {
        if (n < 1) return false;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int res = 0;
            while (n != 0) {
                res += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(res)) return false;
            else set.add(res);
            n = res;
        }
        return true;
    }

}

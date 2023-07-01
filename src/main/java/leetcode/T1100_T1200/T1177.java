package leetcode.T1100_T1200;

import java.util.ArrayList;
import java.util.List;

public class T1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] bits = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            bits[i + 1] = bits[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        List<Boolean> res = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int count = bits[query[1] + 1] ^ bits[query[0]];
            int oddCount = 0;
            while (count != 0) {
                count &= (count - 1);
                ++oddCount;
            }
            res.add(oddCount <= 2 * query[2] + 1);
        }
        return res;
    }

}

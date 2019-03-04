package leetcode.T400_T500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class T454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int aC : C) {
            for (int aD : D) {
                int sum = aC + aD;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int aA : A) {
            for (int aB : B) {
                res += map.getOrDefault(-1 * (aA + aB), 0);
            }
        }

        return res;
    }

}

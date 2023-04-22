package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class T2404 {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if ((num & 1) == 0) {
                map.compute(num, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int maxCount = 0, res = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

}

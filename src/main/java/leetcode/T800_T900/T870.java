package leetcode.T800_T900;

import java.util.Map;
import java.util.TreeMap;

public class T870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(num + 1);
            if (entry == null) {
                entry = map.firstEntry();
            }
            res[index++] = entry.getKey();
            if (entry.getValue() == 1) map.remove(entry.getKey());
            else map.put(entry.getKey(), entry.getValue() - 1);
        }
        return res;
    }

}

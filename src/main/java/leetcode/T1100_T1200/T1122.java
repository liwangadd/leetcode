package leetcode.T1100_T1200;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class T1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int item : arr1) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for (int item : arr2) {
            Integer count = map.get(item);
            while (count-- > 0) res[index++] = item;
            map.remove(item);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            while (count-- > 0) res[index++] = entry.getKey();
        }
        return res;
    }

}

package leetcode.T700_T800;

import java.util.Map;
import java.util.TreeMap;

public class T732 {

    private Map<Integer, Integer> map;

    public T732() {
        this.map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int res = 0, cur = 0;
        for (Integer cnt : map.values()) {
            cur += cnt;
            res = Math.max(res, cur);
        }
        return res;
    }

}

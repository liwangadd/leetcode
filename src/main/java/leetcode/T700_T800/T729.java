package leetcode.T700_T800;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class T729 {

    private final TreeMap<Integer, Integer> intervals;

    public T729() {
        this.intervals = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = intervals.floorEntry(end);
        if (entry == null || entry.getValue() <= start) {
            intervals.put(start, end);
            return true;
        }
        return false;
    }

}

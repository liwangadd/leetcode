package leetcode.T400_T500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class T432 {

    private Map<String, Integer> key2Count;

    private TreeMap<Integer, HashSet<String>> count2Key;

    public T432() {
        key2Count = new HashMap<>();
        count2Key = new TreeMap<>();
    }

    public void inc(String key) {
        int count = 1;
        if (key2Count.containsKey(key)) {
            count = key2Count.get(key);
            HashSet<String> keys = count2Key.get(count);
            keys.remove(key);
            if (keys.isEmpty()) {
                count2Key.remove(count);
            }
            ++count;
        }
        key2Count.put(key, count);
        HashSet<String> keys = count2Key.get(count);
        if (keys == null) {
            keys = new HashSet<>();
        }
        keys.add(key);
        count2Key.put(count, keys);
    }

    public void dec(String key) {
        if (key2Count.containsKey(key)) {
            int count = key2Count.get(key);
            HashSet<String> keys = count2Key.get(count);
            keys.remove(key);
            if (count == 1) {
                if (keys.isEmpty()) {
                    count2Key.remove(count);
                }
                key2Count.remove(key);
            } else {
                if (keys.isEmpty()) {
                    count2Key.remove(count);
                }
                keys = count2Key.get(count - 1);
                if (keys == null) {
                    keys = new HashSet<>();
                }
                keys.add(key);
                count2Key.put(count - 1, keys);
                key2Count.put(key, count - 1);
            }
        }
    }

    public String getMaxKey() {
        Map.Entry<Integer, HashSet<String>> entry = count2Key.lastEntry();
        if (entry != null) {
            return entry.getValue().iterator().next();
        } else {
            return "";
        }
    }

    public String getMinKey() {
        Map.Entry<Integer, HashSet<String>> entry = count2Key.firstEntry();
        if (entry != null) {
            return entry.getValue().iterator().next();
        } else {
            return "";
        }
    }

}

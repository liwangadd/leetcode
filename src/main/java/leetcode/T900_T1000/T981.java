package leetcode.T900_T1000;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class T981 {

    private Map<String, TreeMap<Integer, String>> timeMap;

    public T981() {
        this.timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new TreeMap<>());
        }
        timeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        } else {
            TreeMap<Integer, String> multiVersion = timeMap.get(key);
            Map.Entry<Integer, String> entry = multiVersion.floorEntry(timestamp);
            if (entry == null) return "";
            else return entry.getValue();
        }
    }

}

package T100_T200;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class T146 {

    private Map<Integer, Integer> lruCache;
    private int capacity;

    public T146(int capacity) {
        lruCache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!lruCache.containsKey(key)) {
            return -1;
        } else {
            int value = lruCache.get(key);
            lruCache.remove(key);
            lruCache.put(key, value);
            return value;
        }
    }

    public void put(int key, int value) {
        if (lruCache.containsKey(key)) {
            lruCache.remove(key);
        } else if (lruCache.size() >= capacity) {
            int oldestKey = lruCache.keySet().iterator().next();
            lruCache.remove(oldestKey);
        }
        lruCache.put(key, value);
    }

    public static void main(String[] args) {
        T146 cache = new T146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));   // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

}

package leetcode.T400_T500;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class T460 {

    static class LFUCache {

        private Map<Integer, Integer> vals;
        private Map<Integer, Integer> counts;
        private Map<Integer, LinkedHashSet<Integer>> lists;
        private int cap;
        private int min = -1;

        public LFUCache(int capacity) {
            vals = new HashMap<>();
            counts = new HashMap<>();
            lists = new HashMap<>();
            this.cap = capacity;
            lists.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if (!vals.containsKey(key)) return -1;
            int count = counts.get(key);
            counts.put(key, count + 1);
            if (!lists.containsKey(count + 1)) {
                lists.put(count + 1, new LinkedHashSet<>());
            }
            lists.get(count + 1).add(key);
            lists.get(count).remove(key);
            if (count == min && lists.get(count).size() == 0) {
                min = count + 1;
            }
            return vals.get(key);
        }

        public void put(int key, int value) {
            if(cap<=0) return;
            if (vals.containsKey(key)) {
                vals.put(key, value);
                get(key);
                return;
            }
            if (vals.size() > cap) {
                int evictKey = lists.get(min).iterator().next();
                lists.get(min).remove(evictKey);
                vals.remove(evictKey);
                counts.remove(evictKey);
            }
            vals.put(key, value);
            counts.put(key, 1);
            min = 1;
            lists.get(1).add(key);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 0 /* capacity */ );
        cache.put(0, 0);
        System.out.println(cache.get(0));

//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.get(3);       // returns 3.
//        cache.put(4, 4);    // evicts key 1.
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
    }

}

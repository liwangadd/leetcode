package leetcode.T300_T400;

import java.util.*;

public class T381 {

    public static class RandomizedCollection {

        private List<Integer> nums;
        private Map<Integer, Set<Integer>> locs;
        private Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            nums = new ArrayList<>();
            locs = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) locs.put(val, new LinkedHashSet<>());
            locs.get(val).add(nums.size());
            nums.add(val);
            return !contain;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) return false;
            int loc = locs.get(val).iterator().next();
            locs.get(val).remove(loc);
            if (loc < nums.size() - 1) {
                int lastOne = nums.get(nums.size() - 1);
                nums.set(loc, lastOne);
                locs.get(lastOne).remove(nums.size() - 1);
                locs.get(lastOne).add(loc);
            }
            nums.remove(nums.size() - 1);
            if (locs.get(val).isEmpty()) locs.remove(val);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }

}

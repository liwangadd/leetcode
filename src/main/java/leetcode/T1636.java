package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T1636 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Tuple> nodes = new HashMap<>();
        for (int num : nums) {
            if (nodes.containsKey(num)) {
                nodes.get(num).freq++;
            } else {
                nodes.put(num, new Tuple(num, 1));
            }
        }
        List<Tuple> tuples = nodes.values().stream().sorted(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.freq == o2.freq ? o2.num - o1.num : o1.freq - o2.freq;
            }
        }).collect(Collectors.toList());
        int[] res = new int[nums.length];
        int index = 0;
        for (Tuple tuple : tuples) {
            for (int i = 0; i < tuple.freq; i++) {
                res[index++] = tuple.num;
            }
        }
        return res;
    }

    private static class Tuple {
        private int num;
        private int freq;

        public Tuple(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

}

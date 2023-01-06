package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T2244 {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> counters = new HashMap<>();
        for (int task : tasks) {
            counters.put(task, counters.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (int count : counters.values()) {
            if (count == 1) return -1;
            res += count / 3;
            count = count % 3;
            res += count / 2;
            if ((count & 1) == 1)
                ++res;
        }
        return res;
    }

}

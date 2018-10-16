package T100_T200;

import java.util.HashMap;
import java.util.Map;

public class T137 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() == 1) return entrySet.getKey();
        }
        return 0;
    }

}
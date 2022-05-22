package leetcode.T500_T600;

import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.Map;

public class T560 {

    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.compute(sum, (key, v) -> v == null ? 1 : v + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        new T560().subarraySum(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1}, 9);
    }

}

package leetcode.T200_T300;

import java.util.HashMap;
import java.util.Map;

public class T219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

}

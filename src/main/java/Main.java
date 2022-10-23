import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pos.containsKey(nums[i])) {
                if (i - pos.get(nums[i]) <= k) return true;
                else pos.put(nums[i], i);
            } else {
                pos.put(nums[i], i);
            }
        }
        return false;
    }

}


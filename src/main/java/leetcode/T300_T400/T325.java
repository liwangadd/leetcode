package leetcode.T300_T400;

import java.util.HashMap;
import java.util.Map;

public class T325 {

    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 0);
        int sum = 0, max = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            sum += nums[i];
            if (hash.containsKey(sum - k)) max = Math.max(max, i - hash.get(sum - k) + 1);
            if(!hash.containsKey(sum)) hash.put(sum, i + 1);
        }
        return max;
    }

}

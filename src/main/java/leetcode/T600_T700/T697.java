package leetcode.T600_T700;

import java.util.HashMap;
import java.util.Map;

public class T697 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int maxDegree = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[1] = i;
                map.get(nums[i])[2]++;
            } else {
                map.put(nums[i], new int[]{i, i, 1});
            }
            maxDegree = Math.max(maxDegree, map.get(nums[i])[2]);
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (entry.getValue()[2] == maxDegree) {
                res = Math.min(res, entry.getValue()[1] - entry.getValue()[0] + 1);
            }
        }
        return res;
    }

}

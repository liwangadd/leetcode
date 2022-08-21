package leetcode.T700_T800;

import java.util.Arrays;

public class T746 {

    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = res[1] = 0;
        for (int i = 0; i < cost.length; ++i) {
            if (i + 1 <= cost.length) res[i + 1] = Math.min(res[i + 1], res[i] + cost[i]);
            if (i + 2 <= cost.length) res[i + 2] = Math.min(res[i + 2], res[i] + cost[i]);
        }
        return res[res.length - 1];
    }

}

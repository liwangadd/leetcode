package leetcode;

import java.util.Arrays;

public class T2279 {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] remains = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            remains[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remains);
        int i = 0, len = remains.length;
        for (i = 0; i < len; ++i) {
            additionalRocks -= remains[i];
            if (additionalRocks <= 0)
                break;
        }
        return Math.min(additionalRocks == 0 ? i + 1 : i, len);
    }

}

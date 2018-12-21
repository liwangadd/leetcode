package leetcode.T100_T200;

import java.util.Arrays;

public class T164 {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        if (gap == 0) return 0;
        int[] minBucks = new int[nums.length - 1], maxBucks = new int[nums.length - 1];
        Arrays.fill(minBucks, Integer.MAX_VALUE);
        Arrays.fill(maxBucks, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == min || num == max) continue;
            int idx = (num - min) / gap;

            minBucks[idx] = Math.min(minBucks[idx], num);
            maxBucks[idx] = Math.max(maxBucks[idx], num);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (maxBucks[i] == Integer.MIN_VALUE && minBucks[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(minBucks[i] - previous, maxGap);
            previous = maxBucks[i];
        }
        maxGap = Math.max(max - previous, maxGap);
        return maxGap;
    }

}

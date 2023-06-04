package leetcode;

public class T1799 {

    public int maxScore(int[] nums) {
        return maximizeScore(nums, nums.length, 1, 0, new int[1 << nums.length]);
    }

    private int maximizeScore(int[] nums, int n, int operationNumber, int mask, int[] cache) {
        if (operationNumber > n / 2) {
            return 0;
        }
        if (cache[mask] != 0) {
            return cache[mask];
        }
        int bestGcdScore = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    continue;
                }
                int currMask = mask | (1 << i) | (1 << j);
                int currGcd = operationNumber * gcd(nums[i], nums[j]);
                bestGcdScore = Math.max(bestGcdScore, currGcd + maximizeScore(nums, n, operationNumber + 1, currMask, cache));
            }
        }
        return cache[mask] = bestGcdScore;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}

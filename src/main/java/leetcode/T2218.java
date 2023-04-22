package leetcode;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.List;

public class T2218 {

    private int[][] dp;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new int[piles.size()][k + 1];
        for (int i = 0; i < piles.size(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(piles, 0, k);
    }

    private int helper(List<List<Integer>> piles, int curIndex, int k) {
        if (curIndex == piles.size()) return 0;
        if (dp[curIndex][k] != -1) return dp[curIndex][k];
        int res = helper(piles, curIndex + 1, k);
        int cur = 0;
        for (int i = 0, len = Math.min(piles.get(curIndex).size(), k); i < len; ++i) {
            cur += piles.get(curIndex).get(i);
            res = Math.max(res, helper(piles, curIndex + 1, k - i - 1) + cur);
        }
        return dp[curIndex][k] = res;
    }

}

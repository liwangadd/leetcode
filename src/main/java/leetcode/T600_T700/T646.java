package leetcode.T600_T700;

import com.google.common.collect.Lists;

import javax.swing.*;
import java.util.Arrays;

public class T646 {

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (p1, p2) -> p1[1] == p2[1] ? p1[0] - p2[0] : p1[1] - p2[1]);
        int[] dp = new int[pairs.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < pairs.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i + 1] = Math.max(dp[j + 1] + 1, dp[i + 1]);
                }
            }
        }
        return dp[pairs.length];
    }

    public static void main(String[] args) {
        int res = new T646().findLongestChain(new int[][]{
                        {-10, -8},
                        {8, 9},
                        {-5, 0},
                        {6, 10},
                        {-6, -4},
                        {1, 7},
                        {9, 10},
                        {-4, 8}
                }
        );
        System.out.println(res);
    }

}

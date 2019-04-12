package leetcode.T600_T700;

import leetcode.T1_T100.T71;

import java.util.Arrays;

public class T718 {

    public int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return 0;
        int maxLen = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= A.length; ++i) {
            for (int j = 1; j <= B.length; ++j) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                maxLen = Math.max(dp[i][j], maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        T718 solution = new T718();
        System.out.println(solution.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

}

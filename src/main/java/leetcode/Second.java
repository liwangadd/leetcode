package leetcode;

import com.sun.scenario.effect.Offset;
import utils.ListNode;
import utils.TreeNode;

import java.util.*;

public class Second {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; ++i) dp[i][0] = dp[i - 1][0] & s1.charAt(i - 1) == s3.charAt(i - 1);
        for (int j = 1; j <= len2; ++j) dp[0][j] = dp[0][j - 1] & s2.charAt(j - 1) == s3.charAt(j - 1);
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                dp[i][j] = dp[i - 1][j] & s1.charAt(i - 1) == s3.charAt(i + j - 1) | dp[i][j - 1] & s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        Second solution = new Second();
//        solution.add();
//        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
//        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
//        for (int num : solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)) {
//            System.out.println(num);
//        }
    }

}

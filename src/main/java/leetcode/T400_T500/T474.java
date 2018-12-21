package leetcode.T400_T500;

public class T474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int[] num = count(str);
            for (int i = m; i >= num[0]; --i) {
                for (int j = n; j >= num[1]; --j) {
                    dp[i][j] = Math.max(1 + dp[i - num[0]][j - num[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public int[] count(String s) {
        int num[] = new int[2];
        for (int i = 0; i < s.length(); ++i) {
            ++num[s.charAt(i) - '0'];
        }
        return num;
    }
}

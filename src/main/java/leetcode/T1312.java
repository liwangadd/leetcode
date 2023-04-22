package leetcode;

public class T1312 {

    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len; ++i) {
            dp[i][i] = 1;
            for (int j = i - 1; j > 0; --j) {
                if (s.charAt(j - 1) == s.charAt(i - 1)) dp[i][j] = dp[i - 1][j + 1] + 2;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
            }
        }
        return len - dp[len][1];
    }

    public static void main(String[] args) {
        new T1312().minInsertions("zzazz");
    }

}

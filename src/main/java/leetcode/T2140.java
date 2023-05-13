package leetcode;

public class T2140 {

    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len];
        dp[len - 1] = questions[len - 1][0];
        for (int i = len - 2; i >= 0; --i) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + (i + 1 + questions[i][1] >= len ? 0 : dp[i + 1 + questions[i][1]]));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        new T2140().mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}});
    }

}

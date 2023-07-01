package leetcode.T1200_T1300;

public class T1277 {

    public int countSquares(int[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                dp[i][j] = matrix[i - 1][j - 1] == 1 ? Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1 : 0;
                res += dp[i][j];
            }
        }
        return res;
    }

}

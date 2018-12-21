package leetcode.T1_T100;

public class T64 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[row];
        dp[0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i] = dp[i - 1] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            for (int j = 0; j < row; j++) {
                dp[j] = (j == 0 ? dp[j] : Math.min(dp[j], dp[j - 1])) + grid[j][i];
            }
        }
        return dp[row - 1];
    }

}

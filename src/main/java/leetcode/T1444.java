package leetcode;

public class T1444 {

    private static final int MOD = (int) (1e9 + 7);

    public int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = pizza[0].length();
        Integer[][][] dp = new Integer[k][rows][cols];
        int[][] preSum = new int[rows + 1][cols + 1];
        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                preSum[i][j] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }
        return helper(rows, cols, k - 1, 0, 0, dp, preSum);
    }

    private int helper(int rows, int cols, int k, int r, int c, Integer[][][] dp, int[][] preSum) {
        if (preSum[r][c] == 0) return 0;
        if (k == 0) return 1;
        if (dp[k][r][c] != null) return dp[k][r][c];
        int ans = 0;
        for (int nr = r + 1; nr < rows; ++nr) {
            if (preSum[r][c] - preSum[nr][c] > 0)
                ans = (ans + helper(rows, cols, k - 1, nr, c, dp, preSum)) % MOD;
        }
        for (int nc = c + 1; nc < cols; ++nc) {
            if (preSum[r][c] - preSum[r][nc] > 0)
                ans = (ans + helper(rows, cols, k - 1, r, nc, dp, preSum)) % MOD;
        }
        return dp[k][r][c] = ans;
    }

}

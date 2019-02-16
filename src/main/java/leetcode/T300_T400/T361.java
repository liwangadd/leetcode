package leetcode.T300_T400;

public class T361 {

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rowCnt = 0, m = grid.length, n = grid[0].length;
        int[] colCnt = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCnt = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; ++k) {
                        if (grid[i][k] == 'E') ++rowCnt;
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCnt[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; ++k) {
                        if (grid[k][j] == 'E') ++colCnt[j];
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowCnt + colCnt[j]);
                }
            }
        }
        return res;
    }

}

package leetcode.T300_T400;

public class T329 {

    private int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int[][] cache;
    private int rowCount, colCount;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        cache = new int[matrix.length][matrix[0].length];
        rowCount = matrix.length;
        colCount = matrix[0].length;
        int res = 0;
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < colCount; ++j) {
                int len = dfs(matrix, i, j);
                res = Math.max(len, res);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= rowCount || j < 0 || j >= colCount) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        int tmpRes = 1;
        for (int[] move : moves) {
            int x = i + move[0], y = j + move[1];
            if (x < 0 || x >= rowCount || y < 0 || y >= colCount || matrix[x][y] >= matrix[i][j]) continue;
            tmpRes = Math.max(dfs(matrix, i + move[0], j + move[1]) + 1, tmpRes);
        }
        cache[i][j] = tmpRes;
        return cache[i][j];
    }

}

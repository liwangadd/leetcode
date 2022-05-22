package leetcode.T500_T600;

public class T576 {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0) return 0;
        int[][] matrix = new int[m][n];
        matrix[startRow][startColumn] = 1;
        int MOD = 1000000007;
        int res = 0;
        int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < maxMove; ++k) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int[] move : moves) {
                        int newRow = i + move[0], newCol = j + move[1];
                        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                            res = (res + matrix[i][j]) % MOD;
                        } else {
                            temp[newRow][newCol] = (temp[newRow][newCol] + matrix[i][j]) % MOD;
                        }
                    }
                }
            }
            matrix = temp;
        }
        return res;
    }

}

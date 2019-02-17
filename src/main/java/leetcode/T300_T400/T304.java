package leetcode.T300_T400;

public class T304 {

    class NumMatrix {

        private int[][] sumMatrix;
        private boolean isBlank;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) isBlank = true;
            else {
                int m = matrix.length, n = matrix[0].length;
                sumMatrix = new int[m + 1][n + 1];
                for (int i = 1; i <= m; ++i) {
                    for (int j = 1; j <= n; ++j) {
                        sumMatrix[i][j] = sumMatrix[i][j - 1] + sumMatrix[i - 1][j] - sumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (isBlank) return 0;
            return sumMatrix[row1][col1] + sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1];
        }
    }

}

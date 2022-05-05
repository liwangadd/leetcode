package leetcode.T500_T600;

public class T566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return mat;
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;
        int curR = 0, curC = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[curR][curC++] = mat[i][j];
                if (curC >= c) {
                    ++curR;
                    curC = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new T566().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
    }

}

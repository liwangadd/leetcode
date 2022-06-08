package leetcode.T800_T900;

public class T867 {

    public int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

}

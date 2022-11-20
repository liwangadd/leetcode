package leetcode.T700_T800;

public class T766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; ++i) {
            int num = matrix[i][0];
            for (int step = 0; i + step < rows && step < cols; ++step) {
                if (matrix[i + step][step] != num) return false;
            }
        }
        for (int i = 0; i < cols; i++) {
            int num = matrix[0][i];
            for (int step = 0; i + step < cols && step < rows; ++step) {
                if (matrix[step][i + step] != num) return false;
            }
        }
        return true;
    }

}

public class T48 {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int size = matrix.length;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size - i - 1; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[size - j - 1][size - i - 1];
                matrix[size - j - 1][size - i - 1] = tmp;
            }
        }
        for (int i = 0; i < size / 2; ++i) {
            for (int j = 0; j < size; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[size - i - 1][j];
                matrix[size - i - 1][j] = tmp;
            }
        }
    }
}

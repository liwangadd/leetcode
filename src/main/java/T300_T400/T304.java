package T300_T400;

public class T304 {

    private int[][] sumMatrix;
    private boolean isBlank = false;

    public T304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            isBlank = true;
        } else {
            sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1, len = matrix.length; i <= len; ++i) {
                for (int j = 1, len2 = matrix[0].length; j <= len2; ++j) {
                    sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] + matrix[i - 1][j - 1] - sumMatrix[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (isBlank) return 0;
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1] + sumMatrix[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1}
        };
        T304 solution = new T304(matrix);
//        System.out.println(solution.sumRegion(2, 1, 4, 3));
//        System.out.println(solution.sumRegion(1, 1, 2, 2));
//        System.out.println(solution.sumRegion(1, 2, 2, 4));
        System.out.println(solution.sumRegion(0, 0, 0, 0));
    }
}

package leetcode.T300_T400;

public class T308 {

    static class NumMatrix {

        private int[][] sum;
        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            int n = matrix.length, m = matrix[0].length;
            this.sum = new int[n][m + 1];
            this.matrix = matrix;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 1; j <= matrix[i].length; j++) {
                    add(matrix[i][j - 1], i, j);
                }
            }
        }

        public void update(int row, int col, int val) {
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return;
            int d = val - matrix[row][col];
            matrix[row][col] = val;
            add(d, row, col + 1);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; ++i) {
                ans += getSum(i, col2 + 1) - getSum(i, col1);
            }
            return ans;
        }

        private void add(int val, int x, int y) {
            while (y <= matrix[x].length) {
                sum[x][y] += val;
                y += y & -y;
            }
        }

        private int getSum(int x, int y) {
            int ans = 0;
            while (y > 0) {
                ans += sum[x][y];
                y -= y & -y;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        NumMatrix solution = new NumMatrix(new int[][]{{1}});
        System.out.println(solution.sumRegion(0, 0, 0, 0));
    }

}

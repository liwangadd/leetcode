package leetcode.T300_T400;

public class T378 {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[m - 1][n - 1];
        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for (int i = 0; i < m; i++) {
                int j = n - 1;
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }

                count += j + 1;
            }

            if (count < k) min = mid + 1;
            else max = mid;
        }
        return min;
    }
}

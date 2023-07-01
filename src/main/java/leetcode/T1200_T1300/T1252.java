package leetcode.T1200_T1300;

public class T1252 {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] index : indices) {
            for (int i = 0; i < n; ++i) {
                ++matrix[index[0]][i];
            }
            for (int i = 0; i < m; ++i) {
                ++matrix[i][index[1]];
            }
        }
        int res = 0;
        for (int[] ints : matrix) {
            for (int num : ints) {
                if ((num & 1) == 1) ++res;
            }
        }
        return res;
    }

}

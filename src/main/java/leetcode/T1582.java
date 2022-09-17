package leetcode;


public class T1582 {

    public int numSpecial(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[] rowFlag = new int[rows], colFlag = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    ++rowFlag[i];
                    ++colFlag[j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[j][j] == 1 && rowFlag[i] == 1 && colFlag[j] == 1)
                    ++res;
            }
        }
        return res;
    }

}

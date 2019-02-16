package leetcode.T300_T400;

public class T311 {

    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        if (A == null || A.length == 0 || B == null || B.length == 0) return null;
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[0].length; ++j) {
                int ans = 0;
                for (int k = 0; k < A[0].length; ++k) {
                    ans += A[i][k] * B[k][j];
                }
                res[i][j] = ans;
            }
        }
        return res;
    }

}

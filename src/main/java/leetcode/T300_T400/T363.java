package leetcode.T300_T400;

import java.util.TreeSet;

public class T363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, res = Integer.MIN_VALUE;
        for (int left = 0; left < cols; ++left) {
            int[] sum = new int[rows];
            for (int right = left; right < cols; ++right) {
                for (int r = 0; r < rows; ++r) {
                    sum[r] += matrix[r][right];
                }
                TreeSet<Integer> curSums = new TreeSet<>();
                curSums.add(0);
                int curMax = Integer.MIN_VALUE, cum = 0;
                for (int s : sum) {
                    cum += s;
                    Integer value = curSums.ceiling(cum - k);
                    if (value != null) curMax = Math.max(curMax, cum - value);
                    curSums.add(cum);
                }
                res = Math.max(res, curMax);
            }
        }
        return res;
    }

}

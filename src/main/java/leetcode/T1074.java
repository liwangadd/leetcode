package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        for (int row = 0, rows = matrix.length; row < rows; ++row) {
            for (int col = 1, cols = matrix[0].length; col < cols; ++col) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }
        int res = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0, cols = matrix[0].length; i < cols; ++i) {
            for (int col = i; col < cols; ++col) {
                counter.clear();
                counter.put(0, 1);
                int cur = 0;
                for (int[] rows : matrix) {
                    cur += rows[col] - (i > 0 ? rows[i - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }

}

package leetcode;

import javax.management.StandardEmitterMBean;
import java.time.temporal.Temporal;
import java.util.Arrays;

public class T1329 {

    public int[][] diagonalSort(int[][] mat) {
        int rowLen = mat.length, colLen = mat[0].length;
        for (int i = 0; i < rowLen; i++) {
            int[] sorted = new int[Math.min(rowLen - i, colLen)];
            for (int step = 0, index = 0; i + step < rowLen && step < colLen; ++step) {
                sorted[index++] = mat[i + step][step];
            }
            Arrays.sort(sorted);
            for (int index = 0, step = 0; index < sorted.length; index++, step++) {
                mat[i + step][step] = sorted[index];
            }
        }
        for (int i = 1; i < colLen; i++) {
            int[] sorted = new int[Math.min(colLen - i, rowLen)];
            for (int step = 0, index = 0; i + step < colLen && step < rowLen; ++step) {
                sorted[index++] = mat[step][i + step];
            }
            Arrays.sort(sorted);
            for (int index = 0, step = 0; index < sorted.length; index++, step++) {
                mat[step][i + step] = sorted[index];
            }
        }
        return mat;
    }

}

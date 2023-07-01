package leetcode.T1200_T1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[][] ans = new int[2][colsum.length];
        for (int j = 0; j < colsum.length; j++) {
            if (colsum[j] == 2) {
                ans[0][j] = 1;
                ans[1][j] = 1;
                lower -= 1;
                upper -= 1;
            } else if (colsum[j] == 0) {
                ans[0][j] = 0;
                ans[1][j] = 0;
            } else {
                if (upper >= lower) {
                    ans[0][j] = 1;
                    ans[1][j] = 0;
                    upper -= 1;
                } else {
                    ans[0][j] = 0;
                    ans[1][j] = 1;
                    lower -= 1;
                }
            }
        }
        return lower == 0 && upper == 0 ? new ArrayList(Arrays.asList(ans[0], ans[1])) : new ArrayList();
    }

}

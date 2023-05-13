package leetcode.T1_T100;

import java.util.ArrayList;
import java.util.List;

public class T54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        for (; top <= bottom && left <= right; ++top, --bottom, ++left, --right) {
            for (int i = left; i <= right; ++i) res.add(matrix[top][i]);
            for (int i = top + 1; i <= bottom; ++i) res.add(matrix[i][right]);
            if (top < bottom) for (int i = right - 1; i >= left; --i) res.add(matrix[bottom][i]);
            if (left < right) for (int i = bottom - 1; i > top; --i) res.add(matrix[i][left]);
        }
        return res;
    }

}

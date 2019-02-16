package leetcode.T200_T300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T296 {

    public int minTotalDistance(int[][] grid) {
        // Write your code here
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        return getMin(rows) + getMin(cols);
    }

    private int getMin(List<Integer> list) {
        Collections.sort(list);
        int left = 0, right = list.size() - 1;
        int sum = 0;
        while (left < right) {
            sum += list.get(right--) - list.get(left++);
        }
        return sum;
    }

}

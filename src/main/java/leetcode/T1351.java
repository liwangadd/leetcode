package leetcode;

public class T1351 {

    public int countNegatives(int[][] grid) {
        int row = 0, col = grid[0].length - 1, res = 0;
        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {
                res += grid.length - row;
                --col;
            } else ++row;
        }
        return res;
    }

}

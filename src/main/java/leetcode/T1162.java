package leetcode;

public class T1162 {

    public int maxDistance(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) continue;
                grid[i][j] = 201;
                if (i > 0) grid[i][j] = Math.min(grid[i][j], grid[i - 1][j] + 1);
                if (j > 0) grid[i][j] = Math.min(grid[i][j], grid[i][j - 1] + 1);
            }
        }
        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                if (grid[i][j] == 1) continue;
                if (i < rows - 1) grid[i][j] = Math.min(grid[i][j], grid[i + 1][j] + 1);
                if (j < cols - 1) grid[i][j] = Math.min(grid[i][j], grid[i][j + 1] + 1);
                res = Math.max(res, grid[i][j]);
            }
        }
        return res == 201 ? -1 : res - 1;
    }

}

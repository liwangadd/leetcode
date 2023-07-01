package leetcode.T1200_T1300;

public class T1254 {

    private static final int[][] MOVES = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int rows, cols;

    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; ++i) {
            if (grid[i][0] == 0) fillOne(grid, i, 0);
            if (grid[i][cols - 1] == 0) fillOne(grid, i, cols - 1);
        }
        for (int i = 0; i < cols; ++i) {
            if (grid[0][i] == 0) fillOne(grid, 0, i);
            if (grid[rows - 1][i] == 0) fillOne(grid, rows - 1, i);
        }
        int res = 0;
        for (int i = 1; i < rows - 1; ++i) {
            for (int j = 1; j < cols - 1; ++j) {
                if (grid[i][j] == 0) {
                    fillOne(grid, i, j);
                    ++res;
                }
            }
        }
        return res;
    }

    private void fillOne(int[][] grid, int i, int j) {
        grid[i][j] = 1;
        for (int[] move : MOVES) {
            int newX = i + move[0], newY = j + move[1];
            if (inArea(newX, newY) && grid[newX][newY] == 0)
                fillOne(grid, newX, newY);
        }
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }

}

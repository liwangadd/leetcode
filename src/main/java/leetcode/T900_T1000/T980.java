package leetcode.T900_T1000;

public class T980 {

    private static final int[][] MOVES = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int rows;
    private int cols;
    private int res;
    private int emptyCount;

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        res = 0;
        int startX = -1, startY = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    ++emptyCount;
                } else if (grid[i][j] == 0) {
                    ++emptyCount;
                }
            }
        }
        helper(grid, startX, startY, 0);
        return res;
    }

    private void helper(int[][] grid, int x, int y, int visitedCount) {
        if (grid[x][y] == 2) {
            if (visitedCount == emptyCount)
                ++res;
            return;
        } else if (grid[x][y] == -1) {
            return;
        }
        grid[x][y] = -2;
        for (int[] move : MOVES) {
            int newX = x + move[0], newY = y + move[1];
            if (inArea(newX, newY) && grid[newX][newY] != -2) {
                helper(grid, newX, newY, visitedCount + 1);
            }
        }
        grid[x][y] = 0;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        new T980().uniquePathsIII(
                new int[][]{
                        {1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}
                }
        );
    }
}

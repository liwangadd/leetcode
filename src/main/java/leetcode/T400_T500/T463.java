package leetcode.T400_T500;

public class T463 {

    private int res = 0;
    private int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j);
                    return res;
                }
            }
        }
        return 0;
    }

    private void helper(int[][] grid, int x, int y) {
        res += 4;
        visited[x][y] = true;
        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                if (grid[newX][newY] == 1) res -= 1;
                if (!visited[newX][newY] && grid[newX][newY] == 1) {
                    helper(grid, newX, newY);
                }
            }
        }
    }

}

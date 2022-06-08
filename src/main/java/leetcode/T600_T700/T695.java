package leetcode.T600_T700;

import basic.graph.GraphTraverse;

public class T695 {

    private static final int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, helper(grid, i, j));
                }
            }
        }
        return res;
    }

    private int helper(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return 0;
        int res = 1;
        grid[i][j] = 0;
        for (int[] move : moves) {
            if (inArea(grid, i + move[0], j + move[1])) {
                res += helper(grid, i + move[0], j + move[1]);
            }
        }
        return res;
    }

    private boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

}

package leetcode;

import java.util.Arrays;

public class T2328 {

    private static final int[][] MOVES = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static final int MOD = (int) (1e9 + 7);

    private int[][] memo;

    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        this.memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + dfs(grid, i, j, m, n)) % MOD;
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (memo[i][j] != -1) return memo[i][j];
        int res = 1;
        for (int[] move : MOVES) {
            int newX = i + move[0], newY = j + move[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] > grid[i][j]) {
                res = (res + dfs(grid, newX, newY, m, n)) % MOD;
            }
        }
        return memo[i][j] = res;
    }

    public static void main(String[] args) {
        new T2328().countPaths(
                new int[][]{{1, 1}, {3, 4}}
        );
    }

}

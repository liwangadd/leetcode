package leetcode.T900_T1000;

import java.util.LinkedList;
import java.util.Queue;

public class T934 {

    private static final int[][] MOVES = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int rows, cols;

    public int shortestBridge(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean founded = false;
        for (int i = 0; i < rows; ++i) {
            if (founded) break;
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    founded = true;
                    dfs(grid, i, j, queue);
                    break;
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                for (int[] move : MOVES) {
                    int newX = pos[0] + move[0], newY = pos[1] + move[1];
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                        if (grid[newX][newY] == 1) return step;
                        else if (grid[newX][newY] == 0) {
                            grid[newX][newY] = -1;
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }
            ++step;
        }
        return step;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        queue.add(new int[]{i, j});
        grid[i][j] = -1;
        for (int[] move : MOVES) {
            int newX = i + move[0], newY = j + move[1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1)
                dfs(grid, newX, newY, queue);
        }
    }

}

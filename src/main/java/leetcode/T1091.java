package leetcode;

import basic.graph.GraphTraverse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class T1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        if (grid[0][0] != 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (pos[0] == grid.length - 1 && pos[1] == grid[0].length - 1) return pos[2];
            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    int newRow = pos[0] + i;
                    int newCol = pos[1] + j;
                    if (inArea(grid, newRow, newCol) && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                        queue.add(new int[]{newRow, newCol, pos[2] + 1});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
        return -1;
    }

    private boolean inArea(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}

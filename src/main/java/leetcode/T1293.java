package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class T1293 {

    private final int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][][] visited = new boolean[rows][cols][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                if (pos[0] == rows - 1 && pos[1] == cols - 1) return res;
                for (int[] move : moves) {
                    int curK = pos[2];
                    int newRow = pos[0] + move[0], newCol = pos[1] + move[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        if (grid[newRow][newCol] == 1) {
                            ++curK;
                        }
                        if (curK <= k && !visited[newRow][newCol][curK]) {
                            visited[newRow][newCol][curK] = true;
                            queue.add(new int[]{newRow, newCol, curK});
                        }
                    }
                }
            }
            ++res;
        }
        return -1;
    }

}

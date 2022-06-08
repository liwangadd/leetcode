package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class T994 {

    private int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int oranges = 0, visitedCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
                if (grid[i][j] != 0) ++oranges;
            }
        }
        if (oranges == 0) return 0;
        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            visitedCount += size;
            ++res;
            while (size-- > 0) {
                int[] pos = queue.poll();
                for (int[] move : moves) {
                    int newRow = pos[0] + move[0];
                    int newCol = pos[1] + move[1];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return visitedCount == oranges ? res : -1;
    }

}

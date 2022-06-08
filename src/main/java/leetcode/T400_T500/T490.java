package leetcode.T400_T500;

import java.util.LinkedList;
import java.util.Queue;

public class T490 {

    private int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length, cols = maze[0].length;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (pos[0] == destination[0] && pos[1] == destination[1]) return true;
            for (int[] move : moves) {
                int row = pos[0], col = pos[1];
                while (row + move[0] >= 0 && row + move[0] < rows && col + move[1] >= 0 && col + move[1] < cols
                        && maze[row + move[0]][col + move[1]] == 0) {
                    row = row + move[0];
                    col = col + move[1];
                }
                if (!visited[row][col]) {
                    queue.add(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        return false;
    }

}

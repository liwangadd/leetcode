package leetcode.T400_T500;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T417 {

    private int rows, cols;

    private static final int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] PV = new boolean[rows][cols];
        boolean[][] AV = new boolean[rows][cols];
        for (int i = 0; i < rows; ++i) {
            flow(PV, heights, i, 0);
            flow(AV, heights, i, cols - 1);
        }
        for (int i = 0; i < cols; i++) {
            flow(PV, heights, 0, i);
            flow(AV, heights, rows - 1, i);
        }
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (PV[i][j] && AV[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void flow(boolean[][] visited, int[][] heights, int x, int y) {
        visited[x][y] = true;
        for (int[] move : moves) {
            int newX = x + move[0], newY = y + move[1];
            if (inArea(newX, newY) && !visited[newX][newY] && heights[newX][newY] >= heights[x][y]) {
                flow(visited, heights, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

}

package leetcode.T700_T800;

import java.util.LinkedList;
import java.util.Queue;

public class T733 {

    private int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length, cols = image[0].length, originColor = image[sr][sc];
        if (originColor == newColor) return image;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            image[pos[0]][pos[1]] = newColor;
            for (int[] move : moves) {
                int newRow = pos[0] + move[0], newCol = pos[1] + move[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] == originColor) {
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return image;
    }

}

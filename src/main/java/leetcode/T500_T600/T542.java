package leetcode.T500_T600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class T542 {

    public int[][] updateMatrix(int[][] mat) {
        int rowLen = mat.length, colLen = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            for (int[] move : moves) {
                int newRow = coordinate[0] + move[0], newCol = coordinate[1] + move[1];
                if (newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen && mat[newRow][newCol] == Integer.MAX_VALUE) {
                    mat[newRow][newCol] = mat[coordinate[0]][coordinate[1]] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        System.out.println(new T542().updateMatrix(new int[][]{
                {0,0,0},{0,1,0},{0,0,0}
        })[1][1]);
    }

}

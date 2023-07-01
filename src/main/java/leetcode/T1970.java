package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class T1970 {

    private static final int[][] MOVES = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = cells.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (isValid(row, col, cells, mid)) left = mid;
            else right = mid - 1;
        }
        return left + 1;
    }

    private boolean isValid(int row, int col, int[][] cells, int mid) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i <= mid; i++) {
            matrix[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                queue.add(new int[]{0, i});
                matrix[0][i] = 1;
            }
        }
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            if (curPos[0] == row - 1) return true;
            for (int[] move : MOVES) {
                int newX = curPos[0] + move[0], newY = curPos[1] + move[1];
                if (newX >= 0 && newX < row & newY >= 0 & newY < col && matrix[newX][newY] == 0) {
                    queue.add(new int[]{newX, newY});
                    matrix[newX][newY] = 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new T1970().latestDayToCross(2, 2,
                new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}}
        );
    }

}

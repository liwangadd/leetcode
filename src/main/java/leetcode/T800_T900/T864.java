package leetcode.T800_T900;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class T864 {

    private static final int[][] MOVES = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length, cols = grid[0].length();
        char[][] matrix = new char[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = grid[i].toCharArray();
        }
        int startX = 0, startY = 0, keyCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '@') {
                    startX = i;
                    startY = j;
                } else if (Character.isUpperCase(matrix[i][j])) {
                    ++keyCount;
                }
            }
        }
        int endKey = (1 << keyCount) - 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + startX + " " + startY);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] status = queue.poll();
                for (int[] move : MOVES) {
                    int newX = status[0] + move[0], newY = status[1] + move[1], newKey = status[2];
                    if (newX < 0 || newX >= rows || newY < 0 || newY >= cols)
                        continue;
                    if (matrix[newX][newY] == '#')
                        continue;
                    char c = matrix[newX][newY];
                    if (Character.isUpperCase(c) && ((newKey >>> (c - 'A')) & 1) == 0)
                        continue;
                    if (Character.isLowerCase(c)) {
                        newKey |= 1 << (c - 'a');
                        if (newKey == endKey) return steps + 1;
                    }
                    if (!visited.contains(newKey + " " + newX + " " + newY)) {
                        visited.add(newKey + " " + newX + " " + newY);
                        queue.add(new int[]{newX, newY, newKey});
                    }
                }
            }
            ++steps;
        }
        return -1;
    }

}

package leetcode.T800_T900;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T827 {

    private static final int[][] MOVES = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int rows;
    private int cols;

    private Node[][] islandArea;

    public int largestIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.islandArea = new Node[rows][cols];
        int counter = 0;
        int maxArea = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islandArea[i][j] = new Node(counter++);
                    createNewNode(grid, i, j, visited);
                    maxArea = Math.max(maxArea, islandArea[i][j].val);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    maxArea = Math.max(maxArea, calcIslandArea(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int calcIslandArea(int[][] grid, int i, int j) {
        Set<Integer> islands = new HashSet<>();
        int area = 0;
        for (int[] move : MOVES) {
            int newX = i + move[0];
            int newY = j + move[1];
            if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || grid[newX][newY] == 0) continue;
            if (islandArea[newX][newY] != null && !islands.contains(islandArea[newX][newY].key)) {
                area += islandArea[newX][newY].val;
                islands.add(islandArea[newX][newY].key);
            }
        }
        return area + 1;
    }

    private void createNewNode(int[][] grid, int i, int j, boolean[][] visited) {
        islandArea[i][j].val++;
        visited[i][j] = true;
        for (int[] move : MOVES) {
            int newX = i + move[0];
            int newY = j + move[1];
            if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || grid[newX][newY] == 0 || visited[newX][newY])
                continue;
            islandArea[newX][newY] = islandArea[i][j];
            createNewNode(grid, newX, newY, visited);
        }
    }

    private static class Node {

        private int key;

        private int val;


        public Node(int key) {
            this.key = key;
            this.val = 0;
        }
    }

    public static void main(String[] args) {
        int res = new T827().largestIsland(new int[][]{{0, 1, 1}, {1, 0, 0}, {1, 1, 0}});
        System.out.println(res);
    }

}

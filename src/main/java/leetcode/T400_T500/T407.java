package leetcode.T400_T500;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T407 {

    private class Node {
        int row, col, height;

        public Node(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    private int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) return 0;
        PriorityQueue<Node> nodes = new PriorityQueue<>(Comparator.comparingInt(n -> n.height));
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            nodes.add(new Node(i, 0, heightMap[i][0]));
            nodes.add(new Node(i, n - 1, heightMap[i][n - 1]));
        }
        for (int i = 0; i < n; ++i) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            nodes.add(new Node(0, i, heightMap[0][i]));
            nodes.add(new Node(m - 1, i, heightMap[m - 1][i]));
        }
        int res = 0;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            for (int[] move : moves) {
                int newRow = node.row + move[0];
                int newCol = node.col + move[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    res += Math.max(0, node.height - heightMap[newRow][newCol]);
                    visited[newRow][newCol] = true;
                    nodes.add(new Node(newRow, newCol, Math.max(heightMap[newRow][newCol], node.height)));
                }
            }
        }

        return res;
    }

}

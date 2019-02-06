package leetcode.T300_T400;

import java.util.LinkedList;
import java.util.Queue;

public class T317 {

    private final static int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length, m = grid[0].length;
        int[][] cnt = new int[n][m];
        int res = Integer.MAX_VALUE, flag = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 1) continue;
                res = Integer.MAX_VALUE;
                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(i, j, 0));
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    for (int[] move : moves) {
                        int nextX = node.x + move[0], nextY = node.y + move[1];
                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || grid[nextX][nextY] != flag) continue;
                        cnt[nextX][nextY] += node.dis + 1;
                        res = Math.min(cnt[nextX][nextY], res);
                        queue.add(new Node(nextX, nextY, node.dis + 1));
                        grid[nextX][nextY]--;
                    }
                }
                flag--;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private class Node {
        private int x;
        private int y;
        private int dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

}

package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class T2101 {

    public int maximumDetonation(int[][] bombs) {
        int maxCount = 0;
        for (int i = 0; i < bombs.length; ++i) {
            maxCount = Math.max(maxCount, bfs(bombs, i));
        }
        return maxCount;
    }

    private int bfs(int[][] bombs, int index) {
        boolean[] visited = new boolean[bombs.length];
        visited[index] = true;
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            int[] curBomb = bombs[curIndex];
            for (int i = 0; i < bombs.length; ++i) {
                int[] nextBomb = bombs[i];
                if (!visited[i] && 1L * (nextBomb[0] - curBomb[0]) * (nextBomb[0] - curBomb[0]) + 1L * (nextBomb[1] - curBomb[1]) * (nextBomb[1] - curBomb[1]) <= 1L * curBomb[2] * curBomb[2]) {
                    ++count;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new T2101().maximumDetonation(
                new int[][]{
                        {1, 1, 100000}, {100000, 100000, 1}
                }
        );
    }

}

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T2492 {

    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int minScore = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int[] neighbors : graph[vertex]) {
                minScore = Math.min(minScore, neighbors[1]);
                if (!visited[neighbors[0]]) {
                    visited[neighbors[0]] = true;
                    queue.add(neighbors[0]);
                }
            }
        }
        return minScore;
    }

}

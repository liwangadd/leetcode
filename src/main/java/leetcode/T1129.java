package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T1129 {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List[] graph = new List[n];
        for (int[] edge : redEdges) {
            if (graph[edge[0]] == null) graph[edge[0]] = new ArrayList<>();
            graph[edge[0]].add(new int[]{edge[1], 0});
        }
        for (int[] edge : blueEdges) {
            if (graph[edge[0]] == null) graph[edge[0]] = new ArrayList<>();
            graph[edge[0]].add(new int[]{edge[1], 1});
        }
        int[] ans = new int[n];
        boolean[][][] visited = new boolean[n][n][2];
        Arrays.fill(ans, -1);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, -1, 0});
        while (!queue.isEmpty()) {
            int[] prev = queue.poll();
            ans[prev[0]] = ans[prev[0]] == -1 ? prev[2] : Math.min(prev[2], ans[prev[0]]);
            List<int[]> neighbors = graph[prev[0]];
            if (neighbors == null) continue;
            for (int[] neighbor : neighbors) {
                if (visited[prev[0]][neighbor[0]][neighbor[1]] || neighbor[1] == prev[1]) continue;
                visited[prev[0]][neighbor[0]][neighbor[1]] = true;
                queue.offer(new int[]{neighbor[0], neighbor[1], prev[2] + 1});
            }
        }
        return ans;
    }

}

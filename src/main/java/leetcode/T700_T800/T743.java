package leetcode.T700_T800;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class T743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        if (times == null || times.length == 0 || times[0].length == 0) return 0;
        Map<Integer, Map<Integer, Integer>> matrix = new HashMap<>();
        for (int[] time : times) {
            if (!matrix.containsKey(time[0])) {
                matrix.put(time[0], new HashMap<>());
            }
            matrix.get(time[0]).put(time[1], time[2]);
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        queue.add(new int[]{0, k});
        boolean[] visited = new boolean[n + 1];
        int visitedCount = 0, res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (!visited[cur[1]]) {
                visited[cur[1]] = true;
                res = Math.max(res, cur[0]);
                if (++visitedCount == n) return res;
                if (matrix.containsKey(cur[1])) {
                    matrix.get(cur[1]).forEach((v, w) -> queue.add(new int[]{cur[0] + w, v}));
                }
            }
        }
        return -1;
    }

}

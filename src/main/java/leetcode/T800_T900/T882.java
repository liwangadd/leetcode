package leetcode.T800_T900;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class T882 {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new HashMap<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).put(edge[1], edge[2]);
            graph.get(edge[1]).put(edge[0], edge[2]);
        }
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        HashMap<Integer, Integer> visited = new HashMap<>();
        queue.add(new int[]{maxMoves, 0});
        while (!queue.isEmpty()) {
            int[] step = queue.poll();
            int restMoves = step[0];
            int vertex = step[1];
            if (visited.containsKey(vertex)) continue;
            visited.put(vertex, restMoves);
            Map<Integer, Integer> nextMoves = graph.get(vertex);
            for (Map.Entry<Integer, Integer> entry : nextMoves.entrySet()) {
                int newRest = restMoves - entry.getValue() - 1;
                if (!visited.containsKey(entry.getKey()) && newRest >= 0) {
                    queue.add(new int[]{newRest, entry.getKey()});
                }
            }
        }
        int res = visited.size();
        for (int[] edge : edges) {
            int c1 = visited.getOrDefault(edge[0], 0);
            int c2 = visited.getOrDefault(edge[1], 0);
            res += Math.min(c1 + c2, edge[2]);
        }
        return res;
    }

}

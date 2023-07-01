package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class T1514 {

    private static final class Tuple {

        private int vertex;

        private double probability;

        public Tuple(int vertex, double probability) {
            this.vertex = vertex;
            this.probability = probability;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (graph[edge[0]] == null) graph[edge[0]] = new ArrayList<>();
            if (graph[edge[1]] == null) graph[edge[1]] = new ArrayList<>();
            graph[edge[0]].add(new int[]{edge[1], i});
            graph[edge[1]].add(new int[]{edge[0], i});
        }
        Queue<Tuple> queue = new PriorityQueue<>((t1, t2) -> Double.compare(t2.probability, t1.probability));
        Set<Integer> visited = new HashSet<>();
        queue.add(new Tuple(start, 1));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            visited.add(tuple.vertex);
            if (tuple.vertex == end) return tuple.probability;
            List<int[]> neighbors = graph[tuple.vertex];
            if (neighbors == null) continue;
            for (int[] neighbor : neighbors) {
                if (!visited.contains(neighbor[0])) {
                    queue.add(new Tuple(neighbor[0], tuple.probability * succProb[neighbor[1]]));
                }
            }
        }
        return 0;
    }

}

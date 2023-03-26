package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T1466 {

    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
        int res = 0;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        dfs(0, graph, parent, visited);
        for (int[] conn : connections) {
            if (parent[conn[0]] != conn[1]) {
                res++;
            }
        }
        return res;
    }

    private void dfs(int i, List<Integer>[] graph, int[] parent, boolean[] visited) {
        visited[i] = true;
        for (Integer neighbour : graph[i]) {
            if (visited[neighbour]) {
                continue;
            }
            parent[neighbour] = i;
            dfs(neighbour, graph, parent, visited);
        }
    }
}

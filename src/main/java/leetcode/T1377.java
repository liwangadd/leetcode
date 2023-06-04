package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T1377 {

    private double divider = 1;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (edges.length == 0) return target == 1 ? 1 : 0;
        this.divider = 1;
        List<Integer>[] tree = new List[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int[] edge : edges) {
            if (tree[edge[0]] == null) tree[edge[0]] = new ArrayList<>();
            tree[edge[0]].add(edge[1]);
            if (tree[edge[1]] == null) tree[edge[1]] = new ArrayList<>();
            tree[edge[1]].add(edge[0]);
        }
        if (dfs(tree, 1, t, target, visited)) return 1 / divider;
        else return 0;
    }

    private boolean dfs(List<Integer>[] tree, int cur, int t, int target, boolean[] visited) {
        visited[cur] = true;
        if (t == 0 || cur != 1 && tree[cur].size() == 1) return cur == target;
        for (int next : tree[cur]) {
            if (!visited[next] && dfs(tree, next, t - 1, target, visited)) {
                this.divider *= (cur == 1 ? tree[cur].size() : tree[cur].size() - 1);
                return true;
            }
        }
        return false;
    }

}

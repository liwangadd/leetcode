package leetcode.T700_T800;

import java.util.ArrayList;
import java.util.List;

public class T797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(graph, 0, path, res);
        return res;
    }

    private void helper(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        if (node == graph.length - 1)
            res.add(new ArrayList<>(path));
        int[] neighbors = graph[node];
        for (int neighbor : neighbors) {
            path.add(neighbor);
            helper(graph, neighbor, path, res);
            path.remove(path.size() - 1);
        }
    }

}

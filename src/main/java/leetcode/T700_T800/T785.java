package leetcode.T700_T800;

import java.util.HashMap;
import java.util.Map;

public class T785 {

    public boolean isBipartite(int[][] graph) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!map.containsKey(i) && !helper(i, graph, map, true)) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(int node, int[][] graph, Map<Integer, Boolean> map, boolean color) {
        if (map.containsKey(node)) {
            return map.get(node) == color;
        }
        map.put(node, color);
        for (int neighbor : graph[node]) {
            if (!helper(neighbor, graph, map, !color)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new T785().isBipartite(new int[][]{
                {1, 3}, {0, 2}, {1, 3}, {0, 2}
        });
        System.out.println(res);
    }

}

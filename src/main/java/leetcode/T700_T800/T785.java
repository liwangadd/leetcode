package leetcode.T700_T800;

import java.util.HashMap;
import java.util.Map;

public class T785 {

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !helper(i, graph, colors, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(int node, int[][] graph, int[] colors, int color) {
        if (colors[node] != 0) return colors[node] == color;
        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (!helper(neighbor, graph, colors, color == 1 ? 2 : 1)) {
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

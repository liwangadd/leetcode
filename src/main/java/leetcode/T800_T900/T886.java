package leetcode.T800_T900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T886 {

    private List<Integer>[] graph;
    private Map<Integer, Boolean> colors;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new List[n + 1];
        colors = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (!colors.containsKey(i) && !helper(i, true)) return false;
        }
        return true;
    }

    private boolean helper(int index, boolean color) {
        if (colors.containsKey(index)) return colors.get(index) == color;
        colors.put(index, color);
        for (int i = 0; i < graph[index].size(); i++) {
            if (!helper(graph[index].get(i), !color)) return false;
        }
        return true;
    }

}

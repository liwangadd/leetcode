package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T1443 {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] biTree = new List[n];
        for (int[] edge : edges) {
            if (biTree[edge[0]] == null) {
                biTree[edge[0]] = new ArrayList<>();
            }
            biTree[edge[0]].add(edge[1]);
            if (biTree[edge[1]] == null) {
                biTree[edge[1]] = new ArrayList<>();
            }
            biTree[edge[1]].add(edge[0]);
        }
        return 2 * (Math.max(minTime(biTree, 0, -1, hasApple) - 1, 0));
    }

    private int minTime(List<Integer>[] biTree, int vertex, int parent, List<Boolean> hasApple) {
        List<Integer> neighbors = biTree[vertex];
        int time = 0;
        for (Integer neighbor : neighbors) {
            if (neighbor == parent) continue;
            time += minTime(biTree, neighbor, vertex, hasApple);
        }
        if (time != 0) {
            return time + 1;
        } else if (hasApple.get(vertex)) {
            return 1;
        } else {
            return 0;
        }
    }

}

package leetcode;

import java.util.Arrays;

public class T2316 {

    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(count, 1);
        for (int[] edge : edges) {
            int p1 = findParent(edge[0], parent);
            int p2 = findParent(edge[1], parent);
            if (p1 != p2) {
                if (count[p1] > count[p2]) {
                    parent[p2] = p1;
                    count[p1] += count[p2];
                } else {
                    parent[p1] = p2;
                    count[p2] += count[p1];
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += n - count[findParent(i, parent)];
        }
        return res / 2L;
    }

    private int findParent(int vertex, int[] parent) {
        if (parent[vertex] == vertex) return vertex;
        return findParent(parent[vertex], parent);
    }

}

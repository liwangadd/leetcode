package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class T2421 {

    private int[] parents, vals;
    // maxCounts[i]: {max, count of max} in the root i
    private int[][] maxCounts;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        this.parents = new int[n];
        this.maxCounts = new int[n][2];
        for (int i = 0; i < n; i++) {
            parents[i] = -1;
            maxCounts[i][0] = vals[i];
            maxCounts[i][1] = 1;
        }

        this.vals = vals;

        // buils the tree with nodes in ascending value order
        Arrays.sort(edges, Comparator.comparingInt(e -> Math.max(vals[e[0]], vals[e[1]])));

        int count = n;
        for (int[] e : edges) {
            count += union(e[0], e[1]);
        }
        return count;
    }

    private int find(int u) {
        return parents[u] < 0 ? u : (parents[u] = find(parents[u]));
    }

    private int union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) {
            return 0;
        }

        parents[pu] = pv;

        int maxVal = Math.max(vals[u], vals[v]);
        int cu = maxCounts[pu][0] == maxVal ? maxCounts[pu][1] : 0;
        int cv = maxCounts[pv][0] == maxVal ? maxCounts[pv][1] : 0;

        maxCounts[pv][0] = maxVal;
        maxCounts[pv][1] = cu + cv;

        // combinatorics multiplication principle
        return cu * cv;
    }

}

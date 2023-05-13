package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class T1697 {

    private static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            return parent[i] = parent[i] == i ? i : find(parent[i]);
        }

        public boolean union(int a, int b) {
            int parent_a = find(a);
            int parent_b = find(b);
            if (parent_a == parent_b)
                return false;
            if (rank[parent_a] >= rank[parent_b]) {
                parent[parent_b] = parent_a;
                rank[parent_a] += rank[parent_b];
            } else {
                parent[parent_a] = parent_b;
                rank[parent_b] += parent_a;
            }
            return true;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] q) {
        int q_len = q.length;
        int[][] queries = new int[q_len][4];
        for (int i = 0; i < q_len; i++) {
            queries[i][0] = q[i][0];
            queries[i][1] = q[i][1];
            queries[i][2] = q[i][2];
            queries[i][3] = i;
        }
        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        boolean[] res = new boolean[q_len];
        UnionFind uf = new UnionFind(n);
        for (int i = 0, j = 0; j < q_len; j++) {
            while (i < edgeList.length && edgeList[i][2] < queries[j][2]) {
                uf.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            res[queries[j][3]] = uf.find(queries[j][0]) == uf.find(queries[j][1]);
        }
        return res;
    }

}

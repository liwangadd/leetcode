package leetcode;

import java.util.Arrays;

public class T1483 {

    private static final int UPPER = 16;

    private final int[][] candidate;

    public T1483(int n, int[] parent) {
        this.candidate = new int[n][UPPER];
        for (int i = 0; i < n; i++) {
            Arrays.fill(candidate[i], -1);
        }
        for (int i = 0; i < n; i++) {
            candidate[i][0] = parent[i];
        }
        for (int i = 1; i < UPPER; i++) {
            for (int j = 0; j < n; j++) {
                if (candidate[j][i - 1] != -1) {
                    candidate[j][i] = candidate[candidate[j][i - 1]][i - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < UPPER; i++) {
            if (((k >> i) & 1) == 1) {
                node = this.candidate[node][i];
                if (node == -1) return -1;
            }
        }
        return node;
    }

}

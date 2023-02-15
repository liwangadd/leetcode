package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T1519 {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
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
        int[] ans = new int[n];
        countSubTrees(biTree, 0, labels, ans, -1);
        return ans;
    }

    private int[] countSubTrees(List<Integer>[] biTree, int vertex, String labels, int[] ans, int parent) {
        int[] cnt = new int[26];
        char c = labels.charAt(vertex);
        for (int neighbor : biTree[vertex]) {
            if (neighbor == parent) continue;
            int[] sub = countSubTrees(biTree, neighbor, labels, ans, vertex);
            for (int i = 0; i < 26; ++i) {
                cnt[i] += sub[i];
            }
        }
        ++cnt[c - 'a'];
        ans[vertex] = cnt[c - 'a'];
        return cnt;
    }

}

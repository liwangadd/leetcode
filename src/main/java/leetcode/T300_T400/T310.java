package leetcode.T300_T400;

import java.util.*;

public class T310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new LinkedList<>();

        for (int i = 0; i < n; i++)
            if (adj.get(i).size() == 1) leaves.add(i);
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new LinkedList<>();
            for (Integer leaf : leaves) {
                for (Integer node : adj.get(leaf)) {
                    adj.get(node).remove(leaf);
                    if (adj.get(node).size() == 1) newLeaves.add(node);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

}

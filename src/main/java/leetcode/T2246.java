package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class T2246 {

    private int res;

    public int longestPath(int[] parent, String s) {
        res = 0;
        List<Integer>[] children = new List[parent.length];
        for (int i = 0; i < parent.length; i++)
            children[i] = new ArrayList<>();
        for (int i = 1; i < parent.length; i++)
            children[parent[i]].add(i);
        dfs(children, s, 0);
        return res;
    }

    private int dfs(List<Integer>[] children, String s, int vertex) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int neighbor : children[vertex]) {
            int cur = dfs(children, s, neighbor);
            if (s.charAt(neighbor) != s.charAt(vertex))
                queue.offer(-cur);
        }
        int big1 = queue.isEmpty() ? 0 : -queue.poll();
        int big2 = queue.isEmpty() ? 0 : -queue.poll();
        res = Math.max(res, big1 + big2 + 1);
        return big1 + 1;
    }

}

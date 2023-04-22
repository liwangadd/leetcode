package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T1857 {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        char[] colorArr = colors.toCharArray();
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }
        int[][] cache = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                ++cache[i][colorArr[i] - 'a'];
            }
        }
        int res = queue.isEmpty() ? 0 : 1, seen = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            ++seen;
            List<Integer> nextVertexes = graph[vertex];
            for (Integer nextVertex : nextVertexes) {
                int nextColor = colorArr[nextVertex] - 'a';
                for (int i = 0; i < 26; i++) {
                    cache[nextVertex][i] = Math.max(cache[nextVertex][i], cache[vertex][i] + (i == nextColor ? 1 : 0));
                    res = Math.max(res, cache[nextVertex][i]);
                }
                if (--inDegree[nextVertex] == 0) queue.add(nextVertex);
            }
        }
        return seen == n ? res : -1;
    }

}

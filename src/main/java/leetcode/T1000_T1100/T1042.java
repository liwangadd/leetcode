package leetcode.T1000_T1100;

import com.sun.org.apache.xpath.internal.operations.And;

import java.util.ArrayList;
import java.util.List;

public class T1042 {

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }
        int[] ans = new int[n];
        for (int i = 1; i <= n; ++i) {
            boolean[] colored = new boolean[5];
            for (Integer next : graph[i]) {
                if (ans[next - 1] != 0)
                    colored[ans[next - 1]] = true;
            }
            for (int j = 1; j < 5; j++) {
                if (!colored[j]) {
                    ans[i - 1] = j;
                    break;
                }
            }
        }
        return ans;
    }

}

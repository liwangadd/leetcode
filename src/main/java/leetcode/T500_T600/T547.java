package leetcode.T500_T600;

import sun.font.TrueTypeFont;

import java.util.LinkedList;
import java.util.Queue;

public class T547 {

    public int findCircleNum(int[][] isConnected) {
        int visitCount = 0;
        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        while (visitCount < isConnected.length) {
            ++res;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    ++visitCount;
                    break;
                }
            }
            int curCity = -1;
            while (!queue.isEmpty()) {
                curCity = queue.poll();
                for (int i = 0; i < visited.length; ++i) {
                    if (!visited[i] && isConnected[curCity][i] == 1) {
                        queue.add(i);
                        visited[i] = true;
                        ++visitCount;
                    }
                }
            }
        }
        return res;
    }

}

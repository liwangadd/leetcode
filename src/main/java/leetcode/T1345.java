package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class T1345 {

    public int minJumps(int[] arr) {
        int len = arr.length;
        Map<Integer, List<Integer>> indicesOfValue = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            indicesOfValue.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[len];
        int steps = 0;
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; --size) {
                int curIndex = queue.poll();
                if (curIndex == len - 1) return steps;
                List<Integer> nextIndexes = indicesOfValue.getOrDefault(arr[curIndex], new ArrayList<>());
                nextIndexes.add(curIndex - 1);
                nextIndexes.add(curIndex + 1);
                for (int index : nextIndexes) {
                    if (index >= 0 && index < len && !visited[index]) {
                        visited[index] = true;
                        queue.add(index);
                    }
                }
                nextIndexes.clear();
            }
            ++steps;
        }
        return 0;
    }

}

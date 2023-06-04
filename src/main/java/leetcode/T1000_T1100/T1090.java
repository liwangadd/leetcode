package leetcode.T1000_T1100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class T1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int len = values.length;
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < values.length; i++) {
            queue.add(new int[]{values[i], i});
        }
        Map<Integer, Integer> counter = new HashMap<>();
        int res = 0;
        while (numWanted > 0 && !queue.isEmpty()) {
            int[] entry = queue.poll();
            counter.put(labels[entry[1]], counter.getOrDefault(labels[entry[1]], 0) + 1);
            if (counter.get(labels[entry[1]]) <= useLimit) {
                res += entry[0];
                --numWanted;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new T1090().largestValsFromLabels(
                new int[]{5, 4, 3, 2, 1},
                new int[]{1, 1, 2, 2, 3},
                3, 1
        );
    }

}

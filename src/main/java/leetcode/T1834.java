package leetcode;

import sun.security.krb5.internal.crypto.Aes128;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T1834 {

    public int[] getOrder(int[][] tasks) {
        int[][] taskWithIndexes = new int[tasks.length][];
        for (int i = 0; i < tasks.length; i++) {
            taskWithIndexes[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(taskWithIndexes, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[2] - o2[2];
        });
        long curTimestamp = taskWithIndexes[0][0];
        int index = 0, resIndex = 0;
        int[] res = new int[tasks.length];
        while (index < tasks.length || !queue.isEmpty()) {
            if (queue.isEmpty()) {
                curTimestamp = Math.max(curTimestamp, taskWithIndexes[index][0]);
            }
            while (index < taskWithIndexes.length && taskWithIndexes[index][0] <= curTimestamp) {
                queue.add(taskWithIndexes[index++]);
            }
            int[] taskWithIndex = queue.poll();
            res[resIndex++] = taskWithIndex[2];
            curTimestamp += taskWithIndex[1];
        }
        return res;
    }

    public static void main(String[] args) {
        new T1834().getOrder(
                new int[][]{
                        {1, 2}, {2, 4}, {3, 2}, {4, 1}
                }
        );
    }

}

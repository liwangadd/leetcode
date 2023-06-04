package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class T2542 {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        int[][] pairs = new int[len][2];
        for (int i = 0; i < nums1.length; i++) pairs[i] = new int[]{nums1[i], nums2[i]};
        Arrays.sort(pairs, (p1, p2) -> p2[1] - p1[1]);
        long sum = 0, maxScore = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            if (queue.size() == k) sum -= queue.poll();
            queue.add(pairs[i][0]);
            sum += pairs[i][0];
            if (queue.size() == k) maxScore = Math.max(maxScore, sum * pairs[i][1]);
        }
        return maxScore;
    }

}

package leetcode.T300_T400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class T373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return res;
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[0] + nums2[e[1]]));
        for (int num : nums1) {
            queue.add(new int[]{num, 0});
        }
        int numLength2 = nums2.length;
        while (!queue.isEmpty() && k-- > 0) {
            int[] pair = queue.poll();
            if (pair[1] < numLength2 - 1) {
                queue.add(new int[]{pair[0], pair[1] + 1});
            }
            pair[1] = nums2[pair[1]];
            res.add(Arrays.stream(pair).boxed().collect(Collectors.toList()));
        }
        return res;
    }
}

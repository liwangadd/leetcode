package leetcode.T800_T900;

import java.util.ArrayDeque;
import java.util.Deque;

public class T862 {

    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length, res = N + 1;
        long[] B = new long[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] = B[i] + nums[i];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >=  k)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }

    public static void main(String[] args) {
        int res = new T862().shortestSubarray(new int[]{1}, 1);
        System.out.println(res);
    }

}

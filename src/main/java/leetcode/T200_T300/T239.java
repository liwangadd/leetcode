package leetcode.T200_T300;

import java.util.*;

public class T239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.add(i);
            if (i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        T239 solution=new T239();
        for (int item : solution.maxSlidingWindow(new int[]{7, 2, 4}, 2)) {
            System.out.println(item);
        }
    }

}

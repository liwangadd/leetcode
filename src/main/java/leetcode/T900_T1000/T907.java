package leetcode.T900_T1000;

import java.util.ArrayDeque;
import java.util.Deque;

public class T907 {

    private static final int MOD = (int) (1e9 + 7);

    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        long[] left = new long[len], right = new long[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            left[i] = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            right[i] = (stack.isEmpty() ? len : stack.peek()) - i;
            stack.push(i);
        }
        long res = 0;
        for (int i = 0; i < len; i++) {
            res = (res + arr[i] * left[i] * right[i]) % MOD;
        }
        return (int) res;
    }

}

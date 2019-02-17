package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Test1 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        heights = Arrays.copyOf(heights, heights.length + 1);
        heights[heights.length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int pos = stack.pop();
                res = Math.max(res, heights[pos] * (i - 1 - (stack.isEmpty() ? -1 : stack.peek())));
            }
            stack.push(i);
        }
        return res;
    }

}

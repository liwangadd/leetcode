package T1_T100;

import java.util.Arrays;
import java.util.Stack;

public class T84 {

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        heights = Arrays.copyOf(heights, heights.length + 1);
        heights[heights.length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int pos = stack.pop();
                ans = Math.max(ans, heights[pos] * (i - 1 - (stack.isEmpty() ? -1 : stack.peek())));
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1}));
    }

}

package leetcode;

import java.util.Stack;

public class T739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if (temperatures.length < 2) return res;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

}

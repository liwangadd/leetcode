package leetcode.T900_T1000;

import java.util.Stack;

public class T901 {

    private Stack<int[]> stack;

    public T901() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            res += stack.pop()[1];
        }
        stack.push(new int[]{price, res});
        return res;
    }

}

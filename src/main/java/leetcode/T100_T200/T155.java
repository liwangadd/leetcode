package leetcode.T100_T200;

import java.util.LinkedList;
import java.util.List;

public class T155 {

    private List<Integer> stack;
    private int min;

    public T155() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.add(x);
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        int removeItem = stack.remove(stack.size() - 1);
        if (removeItem == min) {
            min = Integer.MAX_VALUE;
            for (Integer integer : stack) {
                if (integer < min) {
                    min = integer;
                }
            }
        }
    }

    public int top() {
        if (stack.size() > 1) {
            return stack.get(stack.size() - 1);
        } else {
            return 0;
        }
    }

    public int getMin() {
        return min;
    }

}

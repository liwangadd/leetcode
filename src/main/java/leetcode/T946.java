package leetcode;

import java.util.Stack;

public class T946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index1 = 0, index2 = 0;
        while (index1 < popped.length) {
            stack.push(pushed[index1++]);
            while (!stack.isEmpty() && stack.peek().equals(popped[index2])) {
                ++index2;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}

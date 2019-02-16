package leetcode.T100_T200;

import java.util.Stack;

public class T155 {

    public static class MinStack {

        private Stack<Integer> minStack;
        private Stack<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            minStack = new Stack<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (!minStack.isEmpty() && x > minStack.peek()) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(x);
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}

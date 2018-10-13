package T200_T300;

import java.util.Stack;

public class T232 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public T232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            int size = stack1.size();
            for (int i = 0; i < size; ++i) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            int size = stack1.size();
            for (int i = 0; i < size; ++i) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        T232 queue = new T232();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        queue.empty();
    }

}

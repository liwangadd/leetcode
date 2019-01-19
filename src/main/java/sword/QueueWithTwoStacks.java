package sword;

import java.util.Stack;

public class QueueWithTwoStacks {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int val) {
        in.push(val);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        int val = pop();
        out.push(val);
        return val;
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }


}

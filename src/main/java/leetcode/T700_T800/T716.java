package leetcode.T700_T800;

import java.util.LinkedList;

public class T716 {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> maxStack;

    public T716() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.addLast(x);
        if (maxStack.isEmpty() || maxStack.peekLast() < x) maxStack.addLast(x);
        else maxStack.addLast(maxStack.peekLast());
    }

    public int pop() {
        maxStack.pollLast();
        return stack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int peekMax() {
        return maxStack.peekLast();
    }

    public int popMax() {
        int max = peekMax();
        LinkedList<Integer> buffer = new LinkedList<>();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }

    public static void main(String[] args) {
        T716 stack = new T716();
        stack.push(5);
        stack.push(1);
        stack.pop();
    }

}

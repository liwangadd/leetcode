package leetcode;

import java.util.Stack;

public class T1544 {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && Math.abs(stack.lastElement() - c) == 32) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        for(char c: stack) {
            str.append(c);
        }
        return str.toString();
    }

}

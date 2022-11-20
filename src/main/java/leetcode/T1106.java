package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T1106 {

    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : expression.toCharArray()) {
            switch (c) {
                case '!':
                case '&':
                case '|':
                case 't':
                case 'f':
                    stack.push(c);
                    break;
                case ')':
                    List<Character> boolExp = new LinkedList<>();
                    while (stack.peek() == 't' || stack.peek() == 'f') {
                        boolExp.add(stack.pop());
                    }
                    Character logicalExp = stack.pop();
                    if (logicalExp == '!') {
                        stack.push(boolExp.get(0) == 't' ? 'f' : 't');
                    } else if (logicalExp == '&') {
                        boolean isTrue = true;
                        for (Character expr : boolExp) {
                            if (expr == 'f') {
                                isTrue = false;
                                break;
                            }
                        }
                        stack.push(isTrue ? 't' : 'f');
                    } else {
                        boolean isFalse = true;
                        for (Character expr : boolExp) {
                            if (expr == 't') {
                                isFalse = false;
                                break;
                            }
                        }
                        stack.push(isFalse ? 'f' : 't');
                    }
            }
        }
        return stack.pop() == 't' ? true : false;
    }

    public static void main(String[] args) {
        T1106 solution = new T1106();
        System.out.println(solution.parseBoolExpr("&(|(f))"));
        System.out.println(solution.parseBoolExpr("|(f,f,f,t)"));
        System.out.println(solution.parseBoolExpr("!(&(f,t))"));
    }

}

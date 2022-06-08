package leetcode.T800_T900;

import java.util.Stack;

public class T856 {

    public int scoreOfParentheses(String s) {
        Stack<Object> stack = new Stack<>();
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            if (c == '(') stack.push('(');
            else {
                int score = 0;
                Object o = stack.peek();
                if (o instanceof Character) {
                    score = 1;
                } else {
                    while (o instanceof Integer) {
                        stack.pop();
                        score += (Integer) o;
                        o = stack.peek();
                    }
                    score *= 2;
                }
                stack.pop();
                stack.push(score);
            }
        }
        return stack.stream().mapToInt(num->(Integer)num).sum();
    }

    public static void main(String[] args) {
        int res = new T856().scoreOfParentheses("()()");
        System.out.println(res);
    }

}

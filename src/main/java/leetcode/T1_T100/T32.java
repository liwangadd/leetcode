package leetcode.T1_T100;

import java.util.Stack;

public class T32 {

    public int longestValidParentheses(String s) {
        Stack<Integer> brackets = new Stack<>();
        brackets.push(0);
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                brackets.push(i + 1);
            } else {
                brackets.pop();
                if (!brackets.empty()) {
                    res = Math.max(res, i + 1 - brackets.peek());
                } else {
                    brackets.push(i + 1);
                }
            }
        }
        return res;
    }
}

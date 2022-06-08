package leetcode.T700_T800;

import java.util.Deque;
import java.util.LinkedList;

public class T772 {

    public int calculate(String s) {
        int[] result = helper(s,0);
        return result[0];
    }

    public int[] helper(String s, int begin) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[2];
        char presign = '+';
        int n = s.length();
        int num = 0;
        for (int i = begin; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                int[] numNext = helper(s,i + 1);
                num = numNext[0];
                i = numNext[1];
            }
            //对于末尾结束时 或 不是数字字符且字符不为'('时，对num进行处理
            if (i == n - 1 || !Character.isDigit(c) && c != '(') {
                switch (presign) {
                    case '+':deque.push(num);break;
                    case '-':deque.push(-num);break;
                    case '*':deque.push(deque.pop() * num);break;
                    default:deque.push(deque.pop() / num);break;
                }
                //如果结束是右括号，那么就记录位置结束循环。
                if (c == ')') {
                    result[1] = i;
                    break;
                }
                presign = c;
                num = 0;
            }

        }
        while (!deque.isEmpty()) {
            result[0] += deque.pop();
        }
        return result;
    }
}

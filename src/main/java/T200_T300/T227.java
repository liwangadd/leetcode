package T200_T300;

import java.util.Stack;

public class T227 {

    public int calculate(String s) {
        if (s.length() == 0) return 0;
        int num = 0;
        char[] sArr = s.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        char sign = '+';
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (Character.isDigit(sArr[i])) {
                num *= 10;
                num += sArr[i] - '0';
            }
            if ((!Character.isDigit(sArr[i]) && ' ' != sArr[i]) || i == len - 1) {
                if (sign == '-') numStack.push(-num);
                else if (sign == '+') numStack.push(num);
                else if (sign == '*') numStack.push(numStack.pop() * num);
                else numStack.push(numStack.pop() / num);
                num = 0;
                sign = sArr[i];
            }
        }
        int res = 0;
        for (Integer item : numStack) {
            res += item;
        }
        return res;
    }

    public static void main(String[] args) {
        T227 solution = new T227();
        System.out.println(solution.calculate("3+2*2"));
        System.out.println(solution.calculate("3/2"));
        System.out.println(solution.calculate("3+5/2"));
    }

}

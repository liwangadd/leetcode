package leetcode.T200_T300;

import java.util.Stack;

public class T224 {

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        char[] sArr = s.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (Character.isDigit(sArr[i])) {
                int num = 0;
                while (i < len && Character.isDigit(sArr[i])) {
                    num *= 10;
                    num += sArr[i] - '0';
                    ++i;
                }
                if (!numStack.isEmpty()) {
                    char op = operators.pop();
                    if (op != '(') {
                        int num1 = numStack.pop();
                        numStack.add(operation(op, num1, num));
                    } else {
                        numStack.add(num);
                    }
                } else {
                    numStack.add(num);
                }
                --i;
            } else if (sArr[i] == '+' || sArr[i] == '-' || sArr[i] == '(') {
                operators.add(sArr[i]);
            } else {
                char op = operators.pop();
                if (op != '(') {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    numStack.push(operation(op, num2, num1));
                }
            }
        }
        return numStack.pop();
    }

    private int operation(char op, int num1, int num2) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        T224 solution = new T224();
        System.out.println(solution.calculate("1 + 1"));
        System.out.println(solution.calculate("2-1 + 2"));
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(solution.calculate("(((1+3)+2 + (1-2)))"));
    }

}

package T100_T200;

import java.util.Stack;

public class T150 {

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> numStack = new Stack<>();
        Integer n1, n2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                    n2 = numStack.pop();
                    n1 = numStack.pop();
                    if (token.equals("+")) {
                        numStack.push(n1 + n2);
                    } else {
                        numStack.push(n1 - n2);
                    }
                    break;
                case "*":
                case "/":
                    n2 = numStack.pop();
                    n1 = numStack.pop();
                    if (token.equals("*")) {
                        numStack.push(n1 * n2);
                    } else {
                        numStack.push(n1 / n2);
                    }
                    break;
                default:
                    numStack.push(Integer.valueOf(token));
                    break;
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

}

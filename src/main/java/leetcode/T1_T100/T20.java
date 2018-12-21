package leetcode.T1_T100;

import java.util.Stack;

public class T20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char symbol = s.charAt(i);
            if (symbol == '(' || symbol == '[' || symbol == '{') stack.push(symbol);
            else if(stack.empty()) return false;
            else if (symbol == ')' && stack.pop() != '(') return false;
            else if (symbol == ']' && stack.pop() != '[') return false;
            else if (symbol == '}' && stack.pop() != '{') return false;
        }
        if(stack.empty()) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}

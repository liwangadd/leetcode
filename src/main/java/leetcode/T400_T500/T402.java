package leetcode.T400_T500;

import java.util.Stack;

public class T402 {

    public String removeKdigits(String num, int k) {
        if (num.length() == 0 || num.length() == k) return "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                --k;
            }
            stack.push(c);
        }
        while (k-- != 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') ++index;
        return index == sb.length() ? "0" : sb.substring(index);
    }

}

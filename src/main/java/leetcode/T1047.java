package leetcode;

import java.util.LinkedList;

public class T1047 {

    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peekLast().equals(c)) {
                while (!stack.isEmpty() && stack.peekLast().equals(c))
                    stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = new T1047().removeDuplicates("abbaca");
        System.out.println(res);
    }

}

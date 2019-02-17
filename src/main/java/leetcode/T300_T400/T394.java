package leetcode.T300_T400;

import java.util.Stack;

public class T394 {

    public String decodeString(String s) {
        if (s == null) return null;
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder numSb = new StringBuilder();
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            if (Character.isDigit(c)) {
                numSb.append(c - '0');
            } else if (c == ']') {
                int count = numStack.pop();
                char currentChar;
                StringBuilder partSb = new StringBuilder();
                while ((currentChar = charStack.pop()) != '[') {
                    partSb.append(currentChar);
                }
                partSb.reverse();

                while (count-- != 0) {
                    if (!numStack.empty()) {
                        for (int i = 0; i < partSb.length(); ++i) {
                            charStack.add(partSb.charAt(i));
                        }
                    } else {
                        sb.append(partSb);
                    }
                }
            } else {
                if (c == '[') {
                    numStack.add(Integer.valueOf(numSb.toString()));
                    numSb.setLength(0);
                }
                if (numStack.isEmpty()) {
                    sb.append(c);
                } else {
                    charStack.add(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T394 solution = new T394();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution.decodeString("100[leetcode]"));
        System.out.println(solution.decodeString("sd2[f2[e]g]i"));
    }

}

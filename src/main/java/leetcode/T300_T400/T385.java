package leetcode.T300_T400;

import utils.NestedInteger;

import java.util.Stack;

public class T385 {

    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) return null;
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger cur = new NestedInteger();
        stack.add(cur);
        int slow = 1, fast = 1;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (c == '[') {
                NestedInteger childNestedInteger = new NestedInteger();
                cur.getList().add(childNestedInteger);
                stack.push(cur);
                cur = childNestedInteger;
                slow = fast + 1;
            } else if (c == ',') {
                if (slow != fast) {
                    Integer val = Integer.valueOf(s.substring(slow, fast));
                    NestedInteger childNestedInteger = new NestedInteger(val);
                    cur.getList().add(childNestedInteger);
                }
                if (s.charAt(fast + 1) != '[') slow = fast + 1;
            } else if (c == ']') {
                if (Character.isDigit(s.charAt(fast - 1))) {
                    NestedInteger childNestedInteger = new NestedInteger(Integer.valueOf(s.substring(slow, fast)));
                    cur.getList().add(childNestedInteger);
                }
                cur = stack.pop();
                slow = fast + 1;
            }
            ++fast;
        }
        return cur;
    }

    public NestedInteger deserialize2(String s) {
        if (s.isEmpty())
            return null;
        if (s.charAt(0) != '[') // ERROR: special case
            return new NestedInteger(Integer.valueOf(s));

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0; // l shall point to the start of a number substring;
        // r shall point to the end+1 of a number substring
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r+1;
            } else if (ch == ']') {
                String num = s.substring(l, r);
                if (!num.isEmpty())
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r+1;
            } else if (ch == ',') {
                if (s.charAt(r-1) != ']') {
                    String num = s.substring(l, r);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                l = r+1;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        T385 solution = new T385();
        NestedInteger res = solution.deserialize("[-1,-2]");
        printNestedIntegers(res);
    }

    private static void printNestedIntegers(NestedInteger root) {
        if (root.isInteger()) System.out.print(root.getInteger() + ",");
        else {
            System.out.print('[');
            for (NestedInteger nestedInteger : root.getList()) {
                printNestedIntegers(nestedInteger);
            }
            System.out.print(']');
        }
    }
}

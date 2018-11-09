package T300_T400;

import java.util.Stack;

public class T316 {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0, len = s.length(); i < len; ++i) {
            count[s.charAt(i) - 'a']++;
        }
        boolean visited[] = new boolean[26];

        Stack<Character> resStack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; ++i) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (!visited[c - 'a']) {
                while (!resStack.isEmpty() && resStack.peek() >= c && count[resStack.peek() - 'a'] > 0) {
                    char tmpC = resStack.pop();
                    visited[tmpC - 'a'] = false;
                }
                resStack.add(c);
                visited[c - 'a'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : resStack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T316 solution = new T316();
        System.out.println(solution.removeDuplicateLetters("bbcaac"));
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }

}

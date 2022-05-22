package leetcode.T500_T600;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class T557 {

    public String reverseWords(String s) {
        int start = 0;
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                if (i > start) {
                    sb.append(reverse(s.substring(start, i)));
                }
                start = i + 1;
                sb.append(' ');
            }
        }
        if (start < s.length()) {
            sb.append(reverse(s.substring(start, s.length())));
        }
        return sb.toString();
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = str.length() - 1; i >= 0; --i) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}

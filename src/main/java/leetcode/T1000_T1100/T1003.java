package leetcode.T1000_T1100;

public class T1003 {

    public boolean isValid(String s) {
        int len = s.length();
        if (len % 3 != 0) return false;
        char[] stack = new char[len];
        int stackIndex = 0;
        for (char c : s.toCharArray()) {
            stack[stackIndex++] = c;
            while (stackIndex > 2) {
                if (stack[stackIndex - 3] == 'a' && stack[stackIndex - 2] == 'b' && stack[stackIndex - 1] == 'c')
                    stackIndex -= 3;
                else break;
            }
        }
        return stackIndex == 0;
    }

    public static void main(String[] args) {
        new T1003().isValid("abcabcababcc");
    }

}

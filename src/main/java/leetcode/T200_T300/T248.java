package leetcode.T200_T300;

import java.util.Arrays;
import java.util.List;

public class T248 {

    private int res;
    private List<Character> same = Arrays.asList('0', '1', '8');
    private List<char[]> rotate = Arrays.asList(new char[]{'0', '0'}, new char[]{'1', '1'},
            new char[]{'6', '9'}, new char[]{'8', '8'}, new char[]{'9', '6'});

    public int strobogrammaticInRange(String low, String high) {
        res = 0;
        int len1 = low.length(), len2 = high.length();
        for (int i = len1; i <= len2; ++i) {
            if ((i & 1) == 1) {
                for (Character c : same) {
                    helper(Long.valueOf(low), Long.valueOf(high), i - 1, String.valueOf(c));
                }
            } else {
                helper(Long.valueOf(low), Long.valueOf(high), i, "");
            }
        }
        return res;
    }

    private void helper(Long low, Long high, int n, String s) {
        if (n == 0 && Long.valueOf(s) >= low && Long.valueOf(s) <= high) {
            ++res;
            return;
        }
        for (int i = n == 2 ? 1 : 0; i < rotate.size(); ++i) {
            helper(low, high, n - 2, rotate.get(i)[0] + s + rotate.get(i)[1]);
        }
    }

}

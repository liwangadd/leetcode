package leetcode.T300_T400;

import java.util.LinkedList;
import java.util.List;

public class T301 {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        removeInvalidParentheses(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void removeInvalidParentheses(String s, List<String> res, int last_i, int last_j, char[] pair) {
        int count = 0;
        for (int i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == pair[0]) ++count;
            else if (s.charAt(i) == pair[1]) --count;
            if (count >= 0) continue;
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1])) {
                    removeInvalidParentheses(s.substring(0, j) + s.substring(j + 1), res, i, j, pair);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            removeInvalidParentheses(reversed, res, 0, 0, new char[]{')', '('});
        } else res.add(reversed);
    }

}

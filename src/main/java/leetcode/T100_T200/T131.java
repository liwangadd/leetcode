package leetcode.T100_T200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if (s == null || s.length() == 0) return res;

        generate(s, 0, new LinkedList<>(), res);
        return res;
    }

    private void generate(String s, int pos, List<String> resItem, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(resItem));
            return;
        }
        for (int i = pos; i < s.length(); ++i) {
            if (isPalindrome(s, pos, i)) {
                resItem.add(s.substring(pos, i + 1));
                generate(s, i + 1, resItem, res);
                resItem.remove(resItem.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

}

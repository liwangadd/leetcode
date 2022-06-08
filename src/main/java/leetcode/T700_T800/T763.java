package leetcode.T700_T800;

import java.util.LinkedList;
import java.util.List;

public class T763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.length() == 0) return res;
        int[] lastIndexes = new int[26];
        for (int i = 0; i < s.toCharArray().length; i++) {
            lastIndexes[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (lastIndexes[s.charAt(i) - 'a'] == i) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        if (start < s.length()) {
            res.add(s.length() - start);
        }
        return res;
    }

}

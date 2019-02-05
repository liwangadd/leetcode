package leetcode.T200_T300;

import java.util.ArrayList;
import java.util.List;

public class T293 {

    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length() - 1; ++i) {
            if (sArr[i] == '+' && sArr[i + 1] == '+') {
                sArr[i] = '-';
                sArr[i + 1] = '-';
                res.add(new String(sArr));
                sArr[i] = '+';
                sArr[i + 1] = '+';
            }
        }
        return res;
    }

}

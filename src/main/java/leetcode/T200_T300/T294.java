package leetcode.T200_T300;

import java.util.HashMap;
import java.util.Map;

public class T294 {

    private Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        // write your code here
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.substring(i, i + 2).equals("++")) {
                String subStr = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(subStr)) {
                    map.put(subStr, false);
                    return true;
                }
                map.put(subStr, true);
            }
        }
        return false;
    }

}

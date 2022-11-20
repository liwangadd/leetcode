package leetcode.T800_T900;

import java.util.Arrays;

public class T899 {

    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char sArr[] = s.toCharArray();
            Arrays.sort(sArr);
            return new String(sArr);
        }
        String res = s;
        for (int i = 1; i < s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0, i);
            if (res.compareTo(tmp) > 0) res = tmp;
        }
        return res;
    }

}

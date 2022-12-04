package leetcode;

import java.nio.file.FileStore;

public class T1796 {

    public int secondHighest(String s) {
        boolean[] digit = new boolean[10];
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                digit[c - '0'] = true;
            }
        }
        boolean first = false;
        for (int i = 9; i >= 0; --i) {
            if (digit[i]) {
                if (!first) {
                    first = true;
                } else {
                    return i;
                }
            }
        }
        return -1;
    }

}

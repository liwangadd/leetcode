package leetcode;

import sun.util.resources.de.CalendarData_de;

public class T1652 {

    public int[] decrypt(int[] code, int k) {
        int len = code.length, sum = 0;
        int[] res = new int[len];
        if (k == 0) {
            return res;
        } else if (k > 0) {
            for (int start = 1, end = start + k; start < end; ++start) {
                sum += code[start % len];
            }
            for (int i = 0; i < len; ++i) {
                res[i] = sum;
                sum -= code[(i + 1) % len];
                sum += code[(i + 1 + k) % len];
            }
        } else {
            for (int start = -1, end = start + k; start > end; --start) {
                sum += code[(start + len) % len];
            }
            for (int i = 0; i < len; ++i) {
                res[i] = sum;
                sum += code[i];
                sum -= code[(i + k + len) % len];
            }
        }
        return res;
    }

}

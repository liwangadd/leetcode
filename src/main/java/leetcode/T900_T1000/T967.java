package leetcode.T900_T1000;

import java.security.interfaces.RSAKey;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T967 {

    public int[] numsSameConsecDiff(int n, int k) {
        int[] res = new int[1000];
        int size = 9, index = 0;
        for (int i = 1; i < 9; i++) {
            res[index++] = i;
        }
        for (int i = 1; i < n; i++) {
            int[] updated = new int[1000];
            index = 0;
            for (int j = 0; j < size; j++) {
                int mod = res[j] % 10;
                if (mod + k < 10) {
                    updated[index++] = res[j] * 10 + mod + k;
                }
                if (k != 0 && mod - k >= 0) {
                    updated[index++] = res[j] * 10 + mod - k;
                }
            }
            size = i;
            res = updated;
        }
        return Arrays.copyOf(res, size);

    }

}

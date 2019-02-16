package leetcode.T200_T300;

import java.util.Arrays;

public class T204 {

    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        flags[2] = true;
        int i = 2;
        // 结束位置
        int endPos = (int) Math.sqrt(n) + 1;
        while (i < endPos) {
            for (int j = 2; i * j < n; ++j) {
                flags[i * j] = false;
            }
            while (!flags[++i] && i < endPos) ;
        }
        int count = 0;
        for (int j = 2; j < flags.length; ++j) {
            if (flags[j]) ++count;
        }
        return count;
    }

}

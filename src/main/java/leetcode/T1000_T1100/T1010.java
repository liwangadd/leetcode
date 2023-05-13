package leetcode.T1000_T1100;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class T1010 {

    public int numPairsDivisibleBy60(int[] times) {
        int[] counters = new int[60];
        for (int time : times) {
            ++counters[time % 60];
        }
        int res = 0;
        if (counters[0] > 1) {
            if ((counters[0] & 1) == 0) res += (counters[0] / 2 * (counters[0] - 1));
            else res += ((counters[0] - 1) / 2 * counters[0]);
        }
        if (counters[30] > 1) {
            if (((counters[30] & 1) == 0)) res += (counters[30] / 2 * (counters[30] - 1));
            else res += ((counters[30] - 1) / 2 * counters[30]);
        }
        for (int i = 1; i < 30; ++i) {
            res += (counters[i] * counters[60 - i]);
        }
        return res;
    }

}

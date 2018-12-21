package leetcode.T300_T400;

import java.util.Arrays;

public class T313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] vals = new int[primes.length];
        Arrays.fill(vals, 1);
        ugly[0] = 1;
        int next = 1;
        for (int i = 0; i < n; ++i) {
            ugly[i] = next;
            for (int j = 0; j < primes.length; ++j) {
                if (vals[j] == ugly[i]) vals[j] = ugly[idx[j]++] * primes[j];
                next = Math.min(next, vals[j]);
            }
        }
        return ugly[n - 1];
    }

}

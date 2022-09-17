package leetcode.T800_T900;

import java.util.Arrays;

public class T869 {

    public boolean reorderedPowerOf2(int n) {
        int[] counts = counter(n);
        int res = 1;
        for (int i = 0; i < 31; ++i) {
            if (Arrays.equals(counts, counter(res)))
                return true;
            res <<= 1;
        }
        return false;
    }

    private int[] counter(int n) {
        int[] counts = new int[10];
        while (n != 0) {
            ++counts[n % 10];
            n /= 10;
        }
        return counts;
    }

}

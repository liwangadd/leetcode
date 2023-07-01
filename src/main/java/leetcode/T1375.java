package leetcode;

public class T1375 {

    public int numTimesAllBlue(int[] flips) {
        int sum1 = 0, sum2 = 0, res = 0;
        for (int i = 1, len = flips.length; i <= len; ++i) {
            sum1 += i;
            sum2 += flips[i - 1];
            if (sum1 == sum2) ++res;
        }
        return res;
    }

}

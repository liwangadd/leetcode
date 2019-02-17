package leetcode.T300_T400;

public class T342 {

    public boolean isPowerOfFour(int num) {
        double res1 = Math.log10(num) / Math.log10(4);
        return res1 - (int) res1 == 0;
    }

}

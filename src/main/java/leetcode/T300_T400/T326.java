package leetcode.T300_T400;

public class T326 {

    public boolean isPowerOfThree(int n) {
        double m = Math.log10(n) / Math.log10(3.0);
        return m - (int) m == 0;
    }

}

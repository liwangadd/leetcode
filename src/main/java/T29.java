public class T29 {

    public int divide(int dividend_int, int divisor_int) {

        long res = 0;
        long dividend = dividend_int, divisor = divisor_int;
        // god damn corner case
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;
        while (dividend >= divisor) {
            long divisorShift = divisor;
            long time = 1;
            while (dividend >= (divisorShift << 1)) {
                divisorShift = divisorShift << 1;
                time = time << 1;
            }
            dividend = dividend - divisorShift;
            res += time;
        }
        if ((!isNegative && res > Integer.MAX_VALUE) || (isNegative && res < Integer.MIN_VALUE))
            return Integer.MAX_VALUE;
        return isNegative ? (int) -res : (int) res;
    }

}

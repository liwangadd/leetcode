package leetcode.T300_T400;

public class T396 {

    public int maxRotateFunction(int[] A) {
        int last = 0, sum = 0;
        for (int i = 0, len = A.length; i < len; ++i) {
            last += i * A[i];
            sum += A[i];
        }
        int res = last;
        for (int i = 1, len = A.length; i < len; ++i) {
            last = last + sum - len * A[len - i];
            res = Math.max(res, last);
        }
        return res;
    }
}

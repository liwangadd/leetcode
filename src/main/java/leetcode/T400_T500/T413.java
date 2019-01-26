package leetcode.T400_T500;

public class T413 {

    public int numberOfArithmeticSlices(int[] A) {
        int cur = 0, res = 0;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                ++cur;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }

}

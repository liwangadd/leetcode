package leetcode.T200_T300;

public class T201 {

    public int rangeBitwiseAnd(int m, int n) {
        int bitRange = 0;
        while (n != m) {
            n >>= 1;
            m >>= 1;
            ++bitRange;
        }
        return m << bitRange;
    }

    public static void main(String[] args) {
        new T201().rangeBitwiseAnd(100, 200);
    }

}

package leetcode.T300_T400;

public class T365 {

    public boolean canMeasureWater(int x, int y, int z) {
        return x + y <= z && z % (gcd(x, y)) == 0;
    }

    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

}

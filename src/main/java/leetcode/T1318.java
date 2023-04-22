package leetcode;

public class T1318 {

    public int minFlips(int a, int b, int c) {
        int res = 0;
        int xAnd = a & b, xOr = a | b;
        for (int i = 0; i < 32; i++) {
            if ((xAnd >> i & 1) == 1 && (c >> i & 1) == 0) res += 2;
            else if (((xOr >> i & 1) ^ (c >> i & 1)) == 1) res += 1;
        }
        return res;
    }

}

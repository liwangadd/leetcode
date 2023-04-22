package leetcode;

public class T2427 {

    public int commonFactors(int a, int b) {
        if (a < b) return commonFactors(b, a);
        int left = 1, res = 0;
        while (b >= left) {
            if (b % left == 0 && a % left == 0) ++res;
            ++left;
        }
        return res;
    }

}

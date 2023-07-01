package leetcode;

public class T2481 {

    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        else if ((n & 1) == 0) return n / 2;
        else return n;
    }

}

package leetcode.T1_T100;

public class T50 {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        int t = n / 2;
        if (n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res = myPow(x, t);
        if (n % 2 == 0) return res * res;
        return res * res * x;

    }

    public static void main(String[] args) {
        T50 solution = new T50();
        int n = -2147483648;
        System.out.println(-n);
        System.out.println(solution.myPow(2, -2147483648));
    }

}

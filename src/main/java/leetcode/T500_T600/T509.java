package leetcode.T500_T600;

public class T509 {

    public int fib(int N) {
        int a = 0, b = 1;
        for (int i = 0; i < N; ++i) {
            b = a + b;
            a = b - a;
        }
        return a;
    }

}

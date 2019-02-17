package leetcode.T1_T100;

public class T70 {

    private static int climbStairs(int n) {
        int a = 1, b = 1;
        n -= 1;
        while (n-- > 0) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(44));
    }

}

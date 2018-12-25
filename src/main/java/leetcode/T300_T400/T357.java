package leetcode.T300_T400;

public class T357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int res = 10;
        int val = 9;
        for (int i = 2; i <= n && i < 11; ++i) {
            val = (11 - i) * val;
            res += val;
        }
        return res;
    }

    public static void main(String[] args) {
        T357 solution = new T357();
        System.out.println(solution.countNumbersWithUniqueDigits(9));
    }

}

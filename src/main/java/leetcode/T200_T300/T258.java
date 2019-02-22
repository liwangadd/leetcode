package leetcode.T200_T300;

public class T258 {

    public int addDigits(int num) {
        int res, result = 0;
        while (num > 9) {
            res = num;
            result = 0;
            while (res != 0) {
                result = result + res % 10;
                res /= 10;
            }
            num = result;
        }
        return num;
    }

    public int addDigits2(int num) {
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        T258 solution = new T258();
        System.out.println(solution.addDigits(38));
    }

}

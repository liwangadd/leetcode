package leetcode.T500_T600;

public class T507 {

    public boolean checkPerfectNumber(int num) {
        if (num < 0) return false;
        int end = (int) Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= end; ++i) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        if (end * end == num) sum -= end;
        return sum == num;
    }

}

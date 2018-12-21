package leetcode.T300_T400;

public class T371 {

    public int getSum(int a, int b) {
        int sum = a, carry = b;
        while (carry != 0) {
            int tmp = sum;
            sum = tmp ^ carry;
            carry = (tmp & carry) << 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        T371 solution = new T371();
        System.out.println(solution.getSum(1, 2));
        System.out.println(solution.getSum(-2, 3));
    }

}

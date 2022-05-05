package leetcode.T100_T200;

public class T172 {

    public static int trailingZeroes(int n) {
        int count_five = 0;
        while (n > 0) {
            int k = n / 5;
            count_five += k;
            n = k;
        }
        return count_five;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(8));
    }

}

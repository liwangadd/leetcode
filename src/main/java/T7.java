public class T7 {

    private static int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        long result = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            result = result * 10 + temp;
        }
        if (isNegative) {
            result = -result;
        }
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) return 0;
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }

}

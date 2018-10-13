package T300_T400;

public class T400 {

    public static int findNthDigit(int n) {
        int len = 1;
        long cnt = 9;
        int start = 1;
        while (n > len * cnt) {
            n -= len * cnt;
            len++;
            cnt *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        System.out.println(start);
        String s = Integer.toString(start);
        return s.charAt((n - 1) % len) - '0';
    }

    public static void main(String[] args) {
//        System.out.println(findNthDigit(2));
        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(1000000000));
    }

}

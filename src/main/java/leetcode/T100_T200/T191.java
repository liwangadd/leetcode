package leetcode.T100_T200;

public class T191 {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            ++count;
        }
//        while (n != 0) {
//            if ((n & 1) == 1) {
//                ++count;
//            }
//            n >>>= 1;
//        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
        System.out.println(hammingWeight(128));
    }

}

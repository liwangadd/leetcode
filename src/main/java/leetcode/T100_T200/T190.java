package leetcode.T100_T200;

public class T190 {

    public static int reverseBits(int n) {
        long mask = 1;
        long value = 0;
        for (int i = 0; i < 32; ++i) {
            value = (value << 1) | ((n & mask) >>> i);
            mask <<= 1;
        }
        return (int) value;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

}

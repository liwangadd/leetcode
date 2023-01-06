package leetcode;

public class T2180 {

    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; ++i) {
            int sum = 0, cur = i;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            if ((sum & 1) == 0) ++count;
        }
        return count;
    }

}

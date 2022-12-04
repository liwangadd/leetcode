package leetcode;

public class T1742 {

    public int countBalls(int lowLimit, int highLimit) {
        int[] counts = new int[46];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; ++i) {
            int num = i, index = 0;
            while (num != 0) {
                index += (num % 10);
                num /= 10;
            }
            max = Math.max(++counts[index], max);
        }
        return max;
    }

}

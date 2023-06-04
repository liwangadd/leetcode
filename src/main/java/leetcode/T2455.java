package leetcode;

public class T2455 {

    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                ++count;
            }
        }
        if (count == 0) return 0;
        else return sum / count;
    }

}

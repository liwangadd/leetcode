package leetcode;

public class T1800 {

    public int maxAscendingSum(int[] nums) {
        int max = 0, prev = 0, sum = 0;
        for (int num : nums) {
            if (num > prev) {
                prev = num;
                sum += num;
                max = Math.max(max, sum);
            } else {
                prev = sum = 0;
            }
        }
        return max;
    }

}

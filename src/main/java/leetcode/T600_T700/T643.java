package leetcode.T600_T700;

public class T643 {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) return 0;
        long sum = 0;
        int index = 0;
        while (index < k) sum += nums[index++];
        double res = sum * 1.0 / k;
        while (index < nums.length) {
            sum -= nums[index - k];
            sum += nums[index++];
            res = Math.max(res, sum * 1.0 / k);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T643().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

}

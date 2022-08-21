package leetcode.T900_T1000;

public class T918 {

    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, curMax + num);
            curMax = Math.max(curMax + num, 0);
            minSum = Math.min(minSum, curMin + num);
            curMin = Math.min(curMin + num, 0);
        }
        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
    }

    public static void main(String[] args) {
        new T918().maxSubarraySumCircular(new int[]{-3, -2, -3});
    }

}

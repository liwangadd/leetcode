package leetcode.T1000_T1100;

public class T1031 {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(helper(nums, firstLen, secondLen), helper(nums, secondLen, firstLen));
    }

    private int helper(int[] nums, int firstLen, int secondLen) {
        int firstSum = 0, secondSum = 0, index = 0;
        for (; index < firstLen; ++index) firstSum += nums[index];
        for (int len = firstLen + secondLen; index < len; ++index) secondSum += nums[index];
        int firstMax = firstSum, totalMax = firstMax + secondSum;
        for (int len = nums.length; index < len; ++index) {
            secondSum = secondSum + nums[index] - nums[index - secondLen];
            firstSum = firstSum + nums[index - secondLen] - nums[index - firstLen - secondLen];
            firstMax = Math.max(firstMax, firstSum);
            totalMax = Math.max(totalMax, firstMax + secondSum);
        }
        return totalMax;
    }

    public static void main(String[] args) {
        new T1031().maxSumTwoNoOverlap(
                new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3
        );
    }

}

package leetcode.T100_T200;

public class T152 {

    public int maxProduct(int[] nums) {
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < 0) {
                maxDp[i] = Math.max(minDp[i - 1] * nums[i], nums[i]);
                minDp[i] = Math.min(maxDp[i - 1] * nums[i], nums[i]);
            } else {
                maxDp[i] = Math.max(maxDp[i - 1] * nums[i], nums[i]);
                minDp[i] = Math.min(minDp[i - 1] * nums[i], nums[i]);
            }
            if (maxDp[i] > max) max = maxDp[i];
        }
        return max;
    }

}

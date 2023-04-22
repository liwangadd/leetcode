package leetcode;

public class T2439 {

    public int minimizeArrayValue(int[] nums) {
        long prefixSum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prefixSum / i < nums[i]) {
                int tmpRes = (int) Math.ceil((prefixSum + nums[i]) / (i + 1D));
                res = Math.max(tmpRes, res);
            }
            prefixSum += nums[i];
        }
        return res;
    }

}

package leetcode.T100_T200;

public class T152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int minPrev = nums[0], maxPrev = nums[0];
        int maxSofa = nums[0];
        int maxHere, minHere;
        for (int i = 1; i < nums.length; ++i) {
            maxHere = Math.max(Math.max(maxPrev * nums[i], minPrev * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxPrev * nums[i], minPrev * nums[i]), nums[i]);
            maxSofa = Math.max(maxSofa, maxHere);
            minPrev = minHere;
            maxPrev = maxHere;
        }
        return maxSofa;
    }

}

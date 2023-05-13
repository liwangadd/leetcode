package leetcode.T300_T400;

public class T312 {

    private int[][] cache;

    public int maxCoins(int[] nums) {
        int len = nums.length;
        cache = new int[len][len];
        return maxCoins(nums, 0, len - 1);
    }

    private int maxCoins(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (cache[start][end] != 0) return cache[start][end];
        int max = nums[start];
        for (int i = start; i <= end; ++i) {
            max = Math.max(max, maxCoins(nums, start, i - 1) + getCoin(nums, start - 1) * nums[i] * getCoin(nums, end + 1) + maxCoins(nums, i + 1, end));
        }
        return cache[start][end] = max;
    }

    private int getCoin(int[] nums, int index) {
        return index >= 0 && index < nums.length ? nums[index] : 1;
    }

}

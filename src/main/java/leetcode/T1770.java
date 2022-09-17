package leetcode;

public class T1770 {

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] results = new int[m + 1][m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int multiplier = multipliers[i];
                int right = n - 1 - (i - left);
                results[i][left] = Math.max(multiplier * nums[left] + results[i + 1][left + 1],
                        multiplier * nums[right] + results[i + 1][left]
                );
            }
        }

        return results[0][0];
    }
}

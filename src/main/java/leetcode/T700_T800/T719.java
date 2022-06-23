package leetcode.T700_T800;

import java.util.Arrays;

public class T719 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = Integer.MAX_VALUE, right = nums[n - 1] - nums[0];
        for (int i = 1; i < nums.length; ++i) {
            left = Math.min(left, nums[i] - nums[i - 1]);
        }
        while (left < right) {
            int middle = left + (right - left) / 2, count = 0;
            for (int i = 0, j = 0; i < n; ++i) {
                while (j < n && nums[j] <= nums[i] + middle) ++j;
                count += j - i - 1;
            }
            if (count < k) left = middle + 1;
            else right = middle;
        }
        return left;
    }

}

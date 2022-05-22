package leetcode.T600_T700;

import java.util.Arrays;

public class T698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (k <= 0 || sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return helper(nums, k, nums.length - 1, 0, sum / k, visited);
    }

    private boolean helper(int[] nums, int k, int index, int subSum, int target, boolean[] visited) {
        if (subSum > target) return false;
        if (k == 1) return true;
        if (subSum == target) {
            return helper(nums, k - 1, nums.length - 1, 0, target, visited);
        } else {
            for (int i = index; i >= 0; --i) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (helper(nums, k, i - 1, subSum + nums[i], target, visited)) return true;
                    visited[i] = false;
                }
            }
        }
        return false;
    }

}
